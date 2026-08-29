package com.sesi.astralia.data.repository

import com.sesi.astralia.data.model.Category

interface CategoryRepository {
    suspend fun getAllCategories(): List<Category>
}