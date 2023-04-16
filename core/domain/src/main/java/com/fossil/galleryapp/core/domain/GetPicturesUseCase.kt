package com.fossil.galleryapp.core.domain

import androidx.paging.PagingData
import com.fossil.galleryapp.core.data.repository.MediaRepository
import com.fossil.galleryapp.core.model.Media
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by TC on 16/04/2023.
 */

class GetPicturesUseCase @Inject constructor(
    private val mediaRepository: MediaRepository
) {
    operator fun invoke(): Flow<PagingData<Media>> {
        return mediaRepository.getPictures()
    }
}