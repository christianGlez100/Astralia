package com.sesi.astralia.presenter.viewmodel

import app.cash.turbine.test
import com.sesi.astralia.data.repository.SubCategoryRepository
import com.sesi.astralia.domain.dto.SubCategoryDto
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

class FakeSubCategoryRepository : SubCategoryRepository {
    var shouldReturnError = false
    var subCategories = listOf<SubCategoryDto>()

    override suspend fun getSubCategoriesBySubCategory(categoryId: Long): List<SubCategoryDto> {
        if (shouldReturnError) {
            throw Exception("Fake repository error")
        }
        return subCategories
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
class SubCategoryViewModelTest {

    private lateinit var viewModel: SubCategoryViewModel
    private lateinit var repository: FakeSubCategoryRepository
    private val testDispatcher = StandardTestDispatcher()

    @BeforeTest
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        repository = FakeSubCategoryRepository()
        viewModel = SubCategoryViewModel(repository)
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `initial state is Loading`() = runTest {
        assertTrue(viewModel.state.value is SubCategoryState.Loading)
    }

    @Test
    fun `getSubCategoriesByCategoryId updates state to Success with correct data`() = runTest {
        val expectedData = listOf(
            SubCategoryDto(1, "Sub 1", "Desc 1", "url 1", 1),
            SubCategoryDto(2, "Sub 2", "Desc 2", "url 2", 1)
        )
        repository.subCategories = expectedData

        viewModel.getSubCategoriesByCategoryId(1)
        
        viewModel.state.test {
            // Skip initial Loading if it was already there, but viewModel initializes with Loading
            // The function launch a coroutine, so we might need to skip or wait
            
            val item = awaitItem()
            if (item is SubCategoryState.Loading) {
                val successItem = awaitItem()
                assertTrue(successItem is SubCategoryState.Success)
                assertEquals(expectedData, successItem.subCategories)
            } else {
                assertTrue(item is SubCategoryState.Success)
                assertEquals(expectedData, item.subCategories)
            }
        }
    }

    @Test
    fun `getSubCategoriesByCategoryId updates state to Error on failure`() = runTest {
        repository.shouldReturnError = true

        viewModel.getSubCategoriesByCategoryId(1)

        viewModel.state.test {
            val item = awaitItem()
            if (item is SubCategoryState.Loading) {
                val errorItem = awaitItem()
                assertTrue(errorItem is SubCategoryState.Error)
                assertEquals("Fake repository error", errorItem.message)
            } else {
                assertTrue(item is SubCategoryState.Error)
                assertEquals("Fake repository error", item.message)
            }
        }
    }
}
