package com.albert.architecture.di

import com.albert.architecture.provider.CacheAssetLoader
import com.albert.shared.di.AssetProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class AssetModule {
    @Binds
    abstract fun bindsAssetProvider(
        assetLoader: CacheAssetLoader
    ): AssetProvider
}