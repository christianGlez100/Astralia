package com.sesi.astralia.data.repository

import com.sesi.astralia.domain.dto.CategoryDto


interface CategoryRepository {
    suspend fun getAllCategories(): List<CategoryDto>
}