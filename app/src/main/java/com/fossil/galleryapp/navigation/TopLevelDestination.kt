package com.fossil.galleryapp.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.fossil.galleryapp.core.designsystem.icon.GaIcons
import com.fossil.galleryapp.feature.pictures.R as picturesR
import com.fossil.galleryapp.feature.videos.R as videosR

/**
 * Created by TC on 16/04/2023.
 */

enum class TopLevelDestination(
    val icon: ImageVector,
    val iconTextId: Int
) {
    PICTURES(
        icon = GaIcons.Pictures,
        iconTextId = picturesR.string.text_pictures
    ),
    VIDEOS(
        icon = GaIcons.Videos,
        iconTextId = videosR.string.text_videos
    )
}