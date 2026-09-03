package com.sesi.astralia.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sesi.astralia.data.repository.SubCategoryRepository
import com.sesi.astralia.domain.dto.SubCategoryDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SubCategoryViewModel(private val subCategoryRepository: SubCategoryRepository): ViewModel() {

    private val _state = MutableStateFlow<SubCategoryState>(SubCategoryState.Loading)
    val state: StateFlow<SubCategoryState> = _state

    fun getSubCategoriesByCategoryId(categoryId: Long) {
        viewModelScope.launch {
            try {
                val subCategories = subCategoryRepository.getSubCategoriesBySubCategory(categoryId)
                _state.value = SubCategoryState.Success(subCategories)
            } catch (e: Exception) {
                e.printStackTrace()
                _state.value = SubCategoryState.Error(e.message ?: "Unknown error")
            }
        }
    }
}

sealed class SubCategoryState {
    object Loading: SubCategoryState()
    data class Success(val subCategories: List<SubCategoryDto>): SubCategoryState()
    data class Error(val message: String): SubCategoryState()
}