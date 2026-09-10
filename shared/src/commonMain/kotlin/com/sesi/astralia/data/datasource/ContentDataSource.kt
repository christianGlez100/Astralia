package com.sesi.astralia.data.datasource

import com.sesi.astralia.data.model.ContentComplete
import com.sesi.astralia.data.model.toDomain
import com.sesi.astralia.domain.dto.ContentCompleteDto
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns

class ContentDataSource(private val supabaseClient: SupabaseClient) {
    suspend fun getContentBySubCategory(subCategoryId: Long): List<ContentCompleteDto> {
        return supabaseClient.from("content").select(
            Columns.raw(
                """
                id,
                name,
                description,
                contentType(*)
            """.trimIndent()
            )
        ){
            filter{
                eq("subCategoryId", subCategoryId)
            }
        }.decodeAs<List<ContentComplete>>()
            .map {
                it.toDomain()
            }
    }
}