package com.sesi.astralia.di

import com.sesi.astralia.data.datasource.CategoryDataSource
import com.sesi.astralia.data.repository.CategoryRepository
import com.sesi.astralia.data.repository.impl.CategoryRepositoryImpl
import com.sesi.astralia.presenter.viewmodel.CategoryViewModel
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
    single { CategoryDataSource(get()) }.withOptions { createdAtStart() }
    single<CategoryRepository> { CategoryRepositoryImpl(get()) }.withOptions { createdAtStart() }
    viewModel { CategoryViewModel(get()) }
   // viewModelOf(::CategoryViewModel)
}
