package com.fossil.galleryapp.core.data.repository

import androidx.paging.PagingData
import com.fossil.galleryapp.core.model.Media
import com.fossil.galleryapp.core.storage.GaStorageDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by TC on 16/04/2023.
 */

class OfflineMediaRepository @Inject constructor(
    private val gaStorageDataSource: GaStorageDataSource
) : MediaRepository {
    override fun getPictures(): Flow<PagingData<Media>> {
        return gaStorageDataSource.getPictures()
    }

    override fun getVideos(): Flow<PagingData<Media>> {
        return gaStorageDataSource.getVideos()
    }
}