package com.albert.data.di

import com.albert.data.ConferenceApi
import com.albert.data.ConferenceRepository
import com.albert.data.api.GithubApi
import com.albert.data.repository.ConferenceRepositoryImpl
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module(includes = [DataModule.ApiModule::class])
abstract class DataModule {
    @Binds
    abstract fun bindConferenceRepository(
        repository: ConferenceRepositoryImpl
    ): ConferenceRepository

    @InstallIn(SingletonComponent::class)
    @Module
    internal object ApiModule {

        @Provides
        @Singleton
        fun provideConvert(): Converter.Factory {
            return Json {
                ignoreUnknownKeys = true
            }.asConverterFactory("application/json".toMediaType())
        }

        @Provides
        @Singleton
        fun provideConferenceApi(
            retrofit: Retrofit
        ): ConferenceApi {
            return retrofit.create(ConferenceApi::class.java)
        }

        @Provides
        @Singleton
        fun provideGithubApi(
            okHttpClient: OkHttpClient,
            converterFactory: Converter.Factory
        ): GithubApi {
            return Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(converterFactory)
                .client(okHttpClient)
                .build()
                .create(GithubApi::class.java)
        }
    }

}