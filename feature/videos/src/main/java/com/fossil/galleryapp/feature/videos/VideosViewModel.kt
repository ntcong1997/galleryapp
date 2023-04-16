package com.fossil.galleryapp.feature.videos

import androidx.lifecycle.ViewModel
import com.fossil.galleryapp.core.domain.GetPicturesUseCase
import com.fossil.galleryapp.core.domain.GetVideosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by TC on 16/04/2023.
 */

@HiltViewModel
class VideosViewModel @Inject constructor(
    private val getVideosUseCase: GetVideosUseCase
) : ViewModel() {
    val videos = getVideosUseCase()
}