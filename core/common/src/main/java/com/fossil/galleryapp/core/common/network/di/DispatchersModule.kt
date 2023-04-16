package com.fossil.galleryapp.core.common.network.di

import com.fossil.galleryapp.core.common.network.Dispatcher
import com.fossil.galleryapp.core.common.network.GaDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {
    @Provides
    @Dispatcher(GaDispatchers.IO)
    fun providesIODispatcher(): CoroutineDispatcher = Dispatchers.IO
}
