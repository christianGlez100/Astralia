package com.sesi.astralia.data.model

import com.sesi.astralia.domain.dto.ContentCompleteDto

data class ContentResponse(
    val contents: List<ContentComplete>
)

fun ContentResponse.toDomain(): List<ContentCompleteDto> {
    return contents.map { it.toDomain() }
}
