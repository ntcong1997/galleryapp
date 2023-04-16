package com.fossil.galleryapp.core.storage

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.fossil.galleryapp.core.model.Media
import com.fossil.galleryapp.core.storage.paging.PicturesPagingDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by TC on 16/04/2023.
 */

interface GaStorageDataSource {
    fun getPictures(): Flow<PagingData<Media>>
}

class DefaultGaStorageDataSource @Inject constructor(
    private val gaStorage: GaStorage
) : GaStorageDataSource {
    override fun getPictures(): Flow<PagingData<Media>> {
        val picturesPagingDataSource = PicturesPagingDataSource { prevIndex, pageSize ->
            gaStorage.getPictures(prevIndex, pageSize)
        }
        return Pager(PagingConfig(pageSize = 20)) {
            picturesPagingDataSource
        }.flow
    }
}