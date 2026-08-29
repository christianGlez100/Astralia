package com.sesi.astralia.data.datasource

import com.sesi.astralia.data.model.Category
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from


class CategoryDataSource(private val supabaseClient: SupabaseClient) {
    suspend fun getAllCategories(): List<Category> {
        return supabaseClient.from("category").select().decodeList<Category>()
    }
}