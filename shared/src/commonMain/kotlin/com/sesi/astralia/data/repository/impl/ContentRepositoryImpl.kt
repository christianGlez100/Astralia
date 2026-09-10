package com.sesi.astralia.data.repository.impl

import com.sesi.astralia.data.datasource.ContentDataSource
import com.sesi.astralia.data.repository.ContentRepository
import com.sesi.astralia.domain.dto.ContentCompleteDto
import com.sesi.astralia.domain.dto.ContentDto

class ContentRepositoryImpl(private val dataSource: ContentDataSource) : ContentRepository {
    override suspend fun getContentBySubCategoryId(subCategoryId: Long): List<ContentCompleteDto> {
        return dataSource.getContentBySubCategory(subCategoryId)
    }
}