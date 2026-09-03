package com.sesi.astralia.data.model

import com.sesi.astralia.domain.dto.ContentCompleteDto
import kotlinx.serialization.Serializable

@Serializable()
data class ContentComplete(
    val id: Long,
    val name: String,
    val description: String,
    val contentType: ContentType
) {
}

fun ContentComplete.toDomain(): ContentCompleteDto {
    return ContentCompleteDto(
        id = id,
        name = name,
        description = description,
        contentType = contentType.toDomain()
    )
}
