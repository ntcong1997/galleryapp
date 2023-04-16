package com.fossil.galleryapp.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.fossil.galleryapp.core.designsystem.icon.GaIcons
import com.fossil.galleryapp.feature.pictures.R as picturesR

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
    )
}