package com.sesi.astralia.data.repository

import com.sesi.astralia.domain.dto.SubCategoryDto

interface SubCategoryRepository {
    suspend fun getSubCategoriesBySubCategory(categoryId: Long): List<SubCategoryDto>
}