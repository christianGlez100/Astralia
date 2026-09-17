package com.sesi.astralia.domain.repository

import com.sesi.astralia.domain.dto.CategoryDto


interface CategoryRepository {
    suspend fun getAllCategories(): List<CategoryDto>
}