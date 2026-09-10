package com.sesi.astralia.domain.dto

data class ContentTypeDto(
    val id: Long,
    val title: String,
    val description: String,
    val image: String,
    val contentId: Long,
    val element: String,
    val symbol: String,
    val virtue: String,
    val characteristics: String
)
