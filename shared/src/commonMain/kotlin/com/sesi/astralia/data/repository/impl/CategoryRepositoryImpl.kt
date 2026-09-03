package com.sesi.astralia.data.repository.impl

import com.sesi.astralia.data.datasource.CategoryDataSource
import com.sesi.astralia.data.repository.CategoryRepository
import com.sesi.astralia.domain.dto.CategoryDto

class CategoryRepositoryImpl(private val dataSource: CategoryDataSource) : CategoryRepository {

    override suspend fun getAllCategories(): List<CategoryDto> {
        return dataSource.getAllCategories()
    }
}