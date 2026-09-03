package com.sesi.astralia.data.model

import com.sesi.astralia.domain.dto.ContentTypeDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable()
@SerialName("contentType")
data class ContentType(
    val id: Long,
    val title: String,
    val description: String,
    val imageUrl: String,
    val contentId: Long,
    val element: String,
    val symbol: String,
    val virtue: String,
    val characteristics: String
)

fun ContentType.toDomain(): ContentTypeDto {
    return ContentTypeDto(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        contentId = contentId,
        element = element,
        symbol = symbol,
        virtue = virtue,
        characteristics = characteristics)
}