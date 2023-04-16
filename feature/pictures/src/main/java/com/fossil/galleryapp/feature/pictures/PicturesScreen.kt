package com.fossil.galleryapp.feature.pictures

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.fossil.galleryapp.core.model.Media
import com.fossil.galleryapp.core.ui.mediaCardItems

/**
 * Created by TC on 16/04/2023.
 */

@Composable
fun PicturesRoute(
    viewModel: PicturesViewModel = hiltViewModel()
) {
    val pictures = viewModel.pictures.collectAsLazyPagingItems()

    PicturesScreen(pictures = pictures)
}

@Composable
fun PicturesScreen(
    pictures: LazyPagingItems<Media>
) {
    LazyColumn {
        mediaCardItems(pictures)
    }
}