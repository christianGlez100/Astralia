package com.sesi.astralia.data.datasource

import com.sesi.astralia.domain.dto.ContentCompleteDto
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns

class ContentDataSource(private val supabaseClient: SupabaseClient) {
    suspend fun getContentBySubCategory(): ContentCompleteDto {
        return supabaseClient.from("content").select(
            Columns.raw(
                """
                id,
                name,
                description,
                contentType:contentType(*)
            """.trimIndent()
            )
        ).decodeAs<ContentCompleteDto>()
    }
}