package com.sesi.astralia.data.repository.impl

import com.sesi.astralia.data.datasource.ContentDataSource
import com.sesi.astralia.data.model.toDomain
import com.sesi.astralia.domain.repository.ContentRepository
import com.sesi.astralia.domain.dto.ContentCompleteDto

class ContentRepositoryImpl(private val dataSource: ContentDataSource) : ContentRepository {
    override suspend fun getContentBySubCategoryId(subCategoryId: Long): List<ContentCompleteDto> {
        return dataSource.getContentBySubCategory(subCategoryId).map {
            it.toDomain()
        }
    }
}