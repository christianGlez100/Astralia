package com.sesi.astralia.data.model

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