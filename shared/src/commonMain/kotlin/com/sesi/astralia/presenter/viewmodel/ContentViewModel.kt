package com.sesi.astralia.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sesi.astralia.data.repository.ContentRepository
import com.sesi.astralia.domain.dto.ContentCompleteDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ContentViewModel(private val contentRepository: ContentRepository) : ViewModel() {
    private val _state = MutableStateFlow<ContentState>(ContentState.Loading)
    val state: StateFlow<ContentState> = _state

    fun getContentBySubCategoryId(subCategoryId: Long) {
        viewModelScope.launch {
            try {
                val content = contentRepository.getContentBySubCategoryId(subCategoryId)
                _state.value = ContentState.Success(content)
            } catch (e: Exception) {
                e.printStackTrace()
                _state.value = ContentState.Error(e.message ?: "Unknown error")
            }
        }
    }
}

sealed class ContentState {
    object Loading : ContentState()
    data class Success(val content: List<ContentCompleteDto>) : ContentState()
    data class Error(val message: String) : ContentState()
}