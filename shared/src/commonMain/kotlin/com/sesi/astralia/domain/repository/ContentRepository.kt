package com.sesi.astralia.domain.repository

import com.sesi.astralia.domain.dto.ContentCompleteDto

interface ContentRepository {
    suspend fun getContentBySubCategoryId(subCategoryId: Long): List<ContentCompleteDto>
}
