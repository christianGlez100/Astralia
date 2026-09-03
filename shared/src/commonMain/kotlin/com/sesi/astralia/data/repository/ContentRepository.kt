package com.sesi.astralia.data.repository

import com.sesi.astralia.domain.dto.ContentCompleteDto

interface ContentRepository {
    suspend fun getContentBySubCategoryId(subCategoryId: Long): ContentCompleteDto
}
