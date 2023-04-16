package com.fossil.galleryapp.core.storage.di

import android.content.Context
import com.fossil.galleryapp.core.storage.DefaultGaStorage
import com.fossil.galleryapp.core.storage.DefaultGaStorageDataSource
import com.fossil.galleryapp.core.storage.GaStorage
import com.fossil.galleryapp.core.storage.GaStorageDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

/**
 * Created by TC on 16/04/2023.
 */

@InstallIn(SingletonComponent::class)
@Module
class StorageModule {
    @Provides
    fun provideGaStorage(
        @ApplicationContext context: Context
    ): GaStorage = DefaultGaStorage(context)

    @Provides
    fun provideGaStorageDataSource(
        gaStorage: GaStorage
    ): GaStorageDataSource = DefaultGaStorageDataSource(gaStorage)
}