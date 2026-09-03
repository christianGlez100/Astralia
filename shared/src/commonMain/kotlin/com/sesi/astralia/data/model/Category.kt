package com.sesi.astralia.data.model

import com.sesi.astralia.domain.dto.CategoryDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable()
@SerialName("category")
data class Category(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val order: Int,
    val description: String,
)

fun Category.toDomain(): CategoryDto{
    return CategoryDto(
        id = id,
        name = name,
        imageUrl = imageUrl,
        order = order,
        description = description
    )
}
