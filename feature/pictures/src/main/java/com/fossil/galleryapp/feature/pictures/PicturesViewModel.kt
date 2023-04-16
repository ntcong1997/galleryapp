package com.fossil.galleryapp.feature.pictures

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.fossil.galleryapp.core.domain.GetPicturesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by TC on 16/04/2023.
 */

@HiltViewModel
class PicturesViewModel @Inject constructor(
    getPicturesUseCase: GetPicturesUseCase
) : ViewModel() {
    val pictures = getPicturesUseCase()
        .cachedIn(viewModelScope)
}