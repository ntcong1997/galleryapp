package com.fossil.galleryapp.feature.pictures.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.fossil.galleryapp.feature.pictures.PicturesRoute

/**
 * Created by TC on 16/04/2023.
 */


const val picturesRoute = "pictures_route"

fun NavController.navigateToPictures(navOptions: NavOptions? = null) {
    this.navigate(picturesRoute, navOptions)
}

fun NavGraphBuilder.picturesScreen() {
    composable(route = picturesRoute) {
        PicturesRoute()
    }
}