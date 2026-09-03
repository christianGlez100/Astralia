package com.sesi.astralia.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sesi.astralia.data.repository.CategoryRepository
import com.sesi.astralia.domain.dto.CategoryDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CategoryViewModel(private val categoryRepository: CategoryRepository): ViewModel() {
    private val _state = MutableStateFlow<CategoryState>(CategoryState.Loading)
    val state: StateFlow<CategoryState> = _state

    fun getAllCategories() {
        viewModelScope.launch {
            try {
                val categories = categoryRepository.getAllCategories()
                _state.value = CategoryState.Success(categories)
            } catch (e: Exception) {
                e.printStackTrace()
                _state.value = CategoryState.Error(e.message ?: "Unknown error")
            }
        }
    }
}

sealed class CategoryState {
    object Loading: CategoryState()
    data class Success(val categories: List<CategoryDto>): CategoryState()
    data class Error(val message: String): CategoryState()
}