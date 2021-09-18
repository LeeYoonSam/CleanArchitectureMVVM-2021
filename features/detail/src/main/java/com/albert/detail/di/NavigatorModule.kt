package com.albert.detail.di

import com.albert.navigator.DetailNavigator
import com.albert.detail.navigation.DetailNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class NavigatorModule {
    @Binds
    abstract fun provideDetailNavigator(
        navigator: DetailNavigatorImpl
    ): DetailNavigator
}