package com.sesi.astralia.data.repository.impl

import com.sesi.astralia.data.datasource.SubCategoryDataSource
import com.sesi.astralia.data.repository.SubCategoryRepository
import com.sesi.astralia.domain.dto.SubCategoryDto

class SubCategoryRepositoryImpl(private val dataSource: SubCategoryDataSource): SubCategoryRepository {
    override suspend fun getSubCategoriesBySubCategory(categoryId: Long): List<SubCategoryDto> {
        return dataSource.getSubCategoriesByCategoryId(categoryId)
    }
    
}