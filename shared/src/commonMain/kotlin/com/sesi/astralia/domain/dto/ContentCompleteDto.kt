package com.sesi.astralia.domain.dto


data class ContentCompleteDto(
    val id: Long,
    val name: String,
    val description: String,
    val contentType: ContentTypeDto
)