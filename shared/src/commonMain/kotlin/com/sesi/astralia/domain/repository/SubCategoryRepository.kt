package com.sesi.astralia.domain.repository

import com.sesi.astralia.domain.dto.SubCategoryDto

interface SubCategoryRepository {
    suspend fun getSubCategoriesBySubCategory(categoryId: Long): List<SubCategoryDto>
}