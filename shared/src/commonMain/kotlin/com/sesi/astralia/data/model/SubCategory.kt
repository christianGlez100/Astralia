package com.sesi.astralia.data.model

import com.sesi.astralia.domain.dto.SubCategoryDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable()
@SerialName("subCategory")
data class SubCategory(
    val id: Long,
    val name: String,
    val description: String,
    val imageUrl: String,
    val categoryId: Long
)

fun SubCategory.toDomain(): SubCategoryDto {
    return SubCategoryDto(
        id = id,
        name = name,
        description = description,
        imageUrl = imageUrl,
        categoryId = categoryId
    )
}