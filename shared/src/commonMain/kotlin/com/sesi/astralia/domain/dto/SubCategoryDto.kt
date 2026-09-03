package com.sesi.astralia.domain.dto


data class SubCategoryDto(
    val id: Long,
    val name: String,
    val description: String,
    val imageUrl: String,
    val categoryId: Long
)