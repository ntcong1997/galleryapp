package com.fossil.galleryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.fossil.galleryapp.core.designsystem.theme.GaTheme
import com.fossil.galleryapp.ui.GalleryApp
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by TC on 16/04/2023.
 */

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GaTheme {
                GalleryApp()
            }
        }
    }
}