package com.sesi.astralia.di

import com.sesi.astralia.data.datasource.CategoryDataSource
import com.sesi.astralia.data.datasource.ContentDataSource
import com.sesi.astralia.data.datasource.SubCategoryDataSource
import com.sesi.astralia.data.repository.CategoryRepository
import com.sesi.astralia.data.repository.ContentRepository
import com.sesi.astralia.data.repository.SubCategoryRepository
import com.sesi.astralia.data.repository.impl.CategoryRepositoryImpl
import com.sesi.astralia.data.repository.impl.ContentRepositoryImpl
import com.sesi.astralia.data.repository.impl.SubCategoryRepositoryImpl
import com.sesi.astralia.presenter.viewmodel.CategoryViewModel
import com.sesi.astralia.presenter.viewmodel.ContentViewModel
import com.sesi.astralia.presenter.viewmodel.SubCategoryViewModel
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.logging.LogLevel
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.storage.Storage
import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.withOptions
import org.koin.dsl.module

fun appModule() = module{
    single {
        createSupabaseClient(
            supabaseUrl = "https://mwdsyzcsnvhwwxadqyzd.supabase.co",
            supabaseKey = "sb_publishable_B_kvMOGQd9dZktkYwLXulQ_zcHi2iPK"
        ) {
            defaultLogLevel = LogLevel.DEBUG
            install(Auth)
            install(Postgrest)
            install(Storage)
        }
    }
    single { SubCategoryDataSource(get()) }.withOptions { createdAtStart() }
    single { ContentDataSource(get()) }.withOptions { createdAtStart() }
    single { CategoryDataSource(get()) }.withOptions { createdAtStart() }
    single<CategoryRepository> { CategoryRepositoryImpl(get()) }.withOptions { createdAtStart() }
    single<SubCategoryRepository> { SubCategoryRepositoryImpl(get()) }.withOptions { createdAtStart() }
    single<ContentRepository> { ContentRepositoryImpl(get()) }.withOptions { createdAtStart() }
    viewModel { CategoryViewModel(get()) }
    viewModel { SubCategoryViewModel(get()) }
    viewModel { ContentViewModel(get()) }
}
