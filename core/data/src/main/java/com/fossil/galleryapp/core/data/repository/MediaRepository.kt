package com.fossil.galleryapp.core.data.repository

import androidx.paging.PagingData
import com.fossil.galleryapp.core.model.Media
import kotlinx.coroutines.flow.Flow

/**
 * Created by TC on 16/04/2023.
 */

interface MediaRepository {
    fun getPictures(): Flow<PagingData<Media>>
    fun getVideos(): Flow<PagingData<Media>>
}