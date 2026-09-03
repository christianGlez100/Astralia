package com.sesi.astralia.domain.dto

data class CategoryDto(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val order: Int,
    val description: String,
)