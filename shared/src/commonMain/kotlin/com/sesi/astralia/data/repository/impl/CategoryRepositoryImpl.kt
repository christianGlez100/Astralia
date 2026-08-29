package com.sesi.astralia.data.repository.impl

import com.sesi.astralia.data.datasource.CategoryDataSource
import com.sesi.astralia.data.model.Category
import com.sesi.astralia.data.repository.CategoryRepository

class CategoryRepositoryImpl(private val dataSource: CategoryDataSource) : CategoryRepository {

    override suspend fun getAllCategories(): List<Category> {
        return dataSource.getAllCategories()
    }
}