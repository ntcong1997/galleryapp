package com.fossil.galleryapp.feature.videos

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.fossil.galleryapp.core.model.Media
import com.fossil.galleryapp.core.ui.PermissionSettingsDialog
import com.fossil.galleryapp.core.ui.mediaCardItems
import com.fossil.galleryapp.core.ui.permissionItem

/**
 * Created by TC on 16/04/2023.
 */

@Composable
fun VideosRoute(
    viewModel: VideosViewModel = hiltViewModel()
) {
    val activity = LocalContext.current as? Activity
    val context = LocalContext.current

    var permissionGranted by remember { mutableStateOf(false) }
    var showPermissionSettingsDialog by remember { mutableStateOf(false) }
    val videos = viewModel.videos.collectAsLazyPagingItems()

    val requestGalleryPermission =
        rememberLauncherForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            if (it.containsValue(false)) {
                permissionGranted = false
                if (activity?.shouldShowRequestPermissionRationale(
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) android.Manifest.permission.READ_MEDIA_VIDEO
                        else android.Manifest.permission.READ_EXTERNAL_STORAGE
                    ) == false
                ) showPermissionSettingsDialog = true
                return@rememberLauncherForActivityResult
            }
            permissionGranted = true
            videos.refresh()
        }

    VideosScreen(
        permissionGranted = permissionGranted,
        showPermissionSettingsDialog = showPermissionSettingsDialog,
        videos = videos,
        onAllowClick = {
            requestGalleryPermission.launch(
                arrayOf(
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) android.Manifest.permission.READ_MEDIA_VIDEO
                    else android.Manifest.permission.READ_EXTERNAL_STORAGE
                )
            )
        },
        onSettingsClick = {
            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
            val uri = Uri.fromParts("package", context.packageName, null)
            intent.data = uri
            context.startActivity(intent)

            showPermissionSettingsDialog = false
        },
        onDismissPermissionSettingsDialog = {
            showPermissionSettingsDialog = false
        }
    )

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
    permissionGranted: Boolean,
    showPermissionSettingsDialog: Boolean,
    videos: LazyPagingItems<Media>,
    onAllowClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onDismissPermissionSettingsDialog: () -> Unit
) {
    val context = LocalContext.current

    LazyColumn {
        if (permissionGranted) mediaCardItems(videos)
        else permissionItem(
            content = context.getString(R.string.content_videos_permission),
            onAllowClick = onAllowClick
        )
    }

    if (showPermissionSettingsDialog) {
        PermissionSettingsDialog(
            onSettingsClick = onSettingsClick,
            onDismissRequest = onDismissPermissionSettingsDialog
        )
    }
}