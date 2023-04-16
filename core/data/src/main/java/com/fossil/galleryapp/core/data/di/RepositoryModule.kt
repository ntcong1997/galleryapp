package com.fossil.galleryapp.core.data.di

import com.fossil.galleryapp.core.data.repository.MediaRepository
import com.fossil.galleryapp.core.data.repository.OfflineMediaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by TC on 16/04/2023.
 */

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindsMediaRepository(
        offlineMediaRepository: OfflineMediaRepository
    ) : MediaRepository
}