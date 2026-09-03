package com.sesi.astralia.data.datasource

import com.sesi.astralia.data.model.Category
import com.sesi.astralia.data.model.toDomain
import com.sesi.astralia.domain.dto.CategoryDto
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from


class CategoryDataSource(private val supabaseClient: SupabaseClient) {
    suspend fun getAllCategories(): List<CategoryDto> {
        return supabaseClient.from("category")
            .select()
            .decodeList<Category>()
            .map { it.toDomain() }
    }
}