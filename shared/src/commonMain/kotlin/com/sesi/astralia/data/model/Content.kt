package com.sesi.astralia.data.model

import com.sesi.astralia.domain.dto.ContentDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable()
@SerialName("content")
data class Content(
    val id: Long,
    val name: String,
    val description: String,
    val subCategoryId: Long
) {
}

fun Content.toDomain(): ContentDto {
    return ContentDto(
        id = id,
        name = name,
        description = description,
        subCategoryId = subCategoryId
    )
}
