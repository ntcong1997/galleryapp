package com.fossil.galleryapp.feature.videos.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.fossil.galleryapp.feature.videos.VideosRoute

/**
 * Created by TC on 16/04/2023.
 */


const val videosRoute = "videos_route"

fun NavController.navigateToVideos(navOptions: NavOptions? = null) {
    this.navigate(videosRoute, navOptions)
}

fun NavGraphBuilder.videosScreen() {
    composable(route = videosRoute) {
        VideosRoute()
    }
}