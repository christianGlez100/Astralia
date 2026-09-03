package com.sesi.astralia.data.datasource


import com.sesi.astralia.data.model.SubCategory
import com.sesi.astralia.data.model.toDomain
import com.sesi.astralia.domain.dto.SubCategoryDto
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from

class SubCategoryDataSource(private val supabaseClient: SupabaseClient) {

    suspend fun getSubCategoriesByCategoryId(categoryId: Long): List<SubCategoryDto> {
        return supabaseClient.from("subCategory")
            .select{
                filter {
                    eq("categoryId", categoryId)
                }
            }
            .decodeList<SubCategory>()
            .map { it.toDomain() }
    }
}