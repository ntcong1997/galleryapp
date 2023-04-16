package com.fossil.galleryapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.fossil.galleryapp.feature.pictures.navigation.picturesRoute
import com.fossil.galleryapp.feature.pictures.navigation.picturesScreen

/**
 * Created by TC on 16/04/2023.
 */

@Composable
fun GalleryAppNavHost(
    navController: NavHostController,
    startDestination: String = picturesRoute
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        picturesScreen()
    }
}