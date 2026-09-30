package com.sesi.astralia.presenter.viewmodel

import app.cash.turbine.test
import com.sesi.astralia.domain.repository.ContentRepository
import com.sesi.astralia.domain.dto.ContentCompleteDto
import com.sesi.astralia.domain.dto.ContentTypeDto
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

class FakeContentRepository : ContentRepository {
    var shouldReturnError = false
    var contentList = listOf<ContentCompleteDto>()

    override suspend fun getContentBySubCategoryId(subCategoryId: Long): List<ContentCompleteDto> {
        if (shouldReturnError) {
            throw Exception("Fake content repository error")
        }
        return contentList
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
class ContentViewModelTest {

    private lateinit var viewModel: ContentViewModel
    private lateinit var repository: FakeContentRepository
    private val testDispatcher = StandardTestDispatcher()

    @BeforeTest
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        repository = FakeContentRepository()
        viewModel = ContentViewModel(repository)
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `initial state is Loading`() = runTest {
        assertTrue(viewModel.state.value is ContentState.Loading)
    }

    @Test
    fun `getContentBySubCategoryId updates state to Success with correct data`() = runTest {
        val expectedData = listOf(
            ContentCompleteDto(
                id = 1,
                name = "Content 1",
                description = "Desc 1",
                contentType = listOf(
                    ContentTypeDto(
                        id = 1,
                        title = "Title 1",
                        description = "Desc 1",
                        image = "url",
                        contentId = 1,
                        element = "Fire",
                        symbol = "Symbol",
                        virtue = "Virtue",
                        characteristics = "Chars"
                    )
                )
            )
        )
        repository.contentList = expectedData

        viewModel.getContentBySubCategoryId(1)

        viewModel.state.test {
            val item = awaitItem()
            if (item is ContentState.Loading) {
                val successItem = awaitItem()
                assertTrue(successItem is ContentState.Success)
                assertEquals(expectedData, successItem.content)
            } else {
                assertTrue(item is ContentState.Success)
                assertEquals(expectedData, item.content)
            }
        }
    }

    @Test
    fun `getContentBySubCategoryId updates state to Error on failure`() = runTest {
        repository.shouldReturnError = true

        viewModel.getContentBySubCategoryId(1)

        viewModel.state.test {
            val item = awaitItem()
            if (item is ContentState.Loading) {
                val errorItem = awaitItem()
                assertTrue(errorItem is ContentState.Error)
                assertEquals("Fake content repository error", errorItem.message)
            } else {
                assertTrue(item is ContentState.Error)
                assertEquals("Fake content repository error", item.message)
            }
        }
    }
}
