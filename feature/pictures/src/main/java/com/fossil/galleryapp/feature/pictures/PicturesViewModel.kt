package com.fossil.galleryapp.feature.pictures

import androidx.lifecycle.ViewModel
import com.fossil.galleryapp.core.domain.GetPicturesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by TC on 16/04/2023.
 */

@HiltViewModel
class PicturesViewModel @Inject constructor(
    private val getPicturesUseCase: GetPicturesUseCase
) : ViewModel() {
    val pictures = getPicturesUseCase()
}