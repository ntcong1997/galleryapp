package com.fossil.galleryapp.feature.videos

import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.fossil.galleryapp.core.model.Media
import com.fossil.galleryapp.core.ui.mediaCardItems

/**
 * Created by TC on 16/04/2023.
 */

@Composable
fun VideosRoute(
    viewModel: VideosViewModel = hiltViewModel()
) {
    val videos = viewModel.videos.collectAsLazyPagingItems()

    VideosScreen(videos = videos)

    val requestGalleryPermission =
        rememberLauncherForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            if (it.containsValue(false)) return@rememberLauncherForActivityResult
            videos.refresh()
        }

    LaunchedEffect(key1 = Unit) {
        requestGalleryPermission.launch(
            arrayOf(
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) android.Manifest.permission.READ_MEDIA_VIDEO
                else android.Manifest.permission.READ_EXTERNAL_STORAGE
            )
        )
    }
}

@Composable
fun VideosScreen(
    videos: LazyPagingItems<Media>
) {
    LazyColumn {
        mediaCardItems(videos)
    }
}