package com.albert.data.di

import com.albert.data.ConferenceApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BASIC
                }
            )
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl("https://github.com/LeeYoonSam/CleanArchitectureMVVM-2021/tree/main/app/src/main/assets/")
        .addConverterFactory(
            Json.asConverterFactory("application/json".toMediaType())
        )
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideConferenceApi(
        retrofit: Retrofit
    ): ConferenceApi {
        return retrofit.create(ConferenceApi::class.java)
    }
}