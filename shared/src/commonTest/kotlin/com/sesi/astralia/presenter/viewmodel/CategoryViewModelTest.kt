package com.sesi.astralia.presenter.viewmodel

import app.cash.turbine.test
import com.sesi.astralia.domain.repository.CategoryRepository
import com.sesi.astralia.domain.dto.CategoryDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class FakeCategoryRepository : CategoryRepository {
    var shouldReturnError = false
    var categories = listOf<CategoryDto>()

    override suspend fun getAllCategories(): List<CategoryDto> {
        if (shouldReturnError) {
            throw Exception("Fake repository error")
        }
        return categories
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
class CategoryViewModelTest {

    private lateinit var viewModel: CategoryViewModel
    private lateinit var repository: FakeCategoryRepository
    private val testDispatcher = StandardTestDispatcher()

    @BeforeTest
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        repository = FakeCategoryRepository()
        viewModel = CategoryViewModel(repository)
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `initial state is Loading`() = runTest {
        assertTrue(viewModel.state.value is CategoryState.Loading)
    }

    @Test
    fun `getAllCategories updates state to Success with correct data`() = runTest {
        val expectedData = listOf(
            CategoryDto(1, "Mysticism", "url 1", 1, "Desc 1"),
            CategoryDto(2, "Astrology", "url 2", 2, "Desc 2")
        )
        repository.categories = expectedData

        viewModel.getAllCategories()
        
        viewModel.state.test {
            val item = awaitItem()
            if (item is CategoryState.Loading) {
                val successItem = awaitItem()
                assertTrue(successItem is CategoryState.Success)
                assertEquals(expectedData, successItem.categories)
            } else {
                assertTrue(item is CategoryState.Success)
                assertEquals(expectedData, item.categories)
            }
        }
    }

    @Test
    fun `getAllCategories updates state to Error on failure`() = runTest {
        repository.shouldReturnError = true

        viewModel.getAllCategories()

        viewModel.state.test {
            val item = awaitItem()
            if (item is CategoryState.Loading) {
                val errorItem = awaitItem()
                assertTrue(errorItem is CategoryState.Error)
                assertEquals("Fake repository error", errorItem.message)
            } else {
                assertTrue(item is CategoryState.Error)
                assertEquals("Fake repository error", item.message)
            }
        }
    }
}
