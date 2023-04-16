package com.fossil.galleryapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.fossil.galleryapp.core.designsystem.theme.BlueRibbon
import com.fossil.galleryapp.core.designsystem.theme.GraySilverChalice
import com.fossil.galleryapp.navigation.GalleryAppNavHost
import com.fossil.galleryapp.navigation.TopLevelDestination

/**
 * Created by TC on 04/03/2023.
 */

@Composable
fun GalleryApp(
    appState: GalleryAppState = rememberGaState()
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Scaffold(
            contentColor = MaterialTheme.colors.onBackground,
            bottomBar = {
                GaBottomNavigation(
                    destinations = appState.topLevelDestinations,
                    onNavigateToDestination = appState::navigateToTopLevelDestination,
                    currentDestination = appState.currentDestination
                )
            }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        PaddingValues(
                            0.dp,
                            0.dp,
                            0.dp,
                            it.calculateBottomPadding()
                        )
                    )
            ) {
                GalleryAppNavHost(navController = appState.navController)
            }
        }
    }
}

@Composable
private fun GaBottomNavigation(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?
) {
    BottomNavigation(
        backgroundColor = Color.White,
        elevation = 8.dp
    ) {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            GaBottomNavigationItem(
                icon = destination.icon,
                iconTextId = destination.iconTextId,
                selected = selected,
                onClick = {
                    onNavigateToDestination(destination)
                }
            )
        }
    }
}

@Composable
fun RowScope.GaBottomNavigationItem(
    icon: ImageVector,
    iconTextId: Int,
    selected: Boolean,
    onClick: () -> Unit
) {
    BottomNavigationItem(
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = null,
            )
        },
        label = {
            Text(
                text = stringResource(id = iconTextId),
                fontSize = 10.sp,
                maxLines = 1
            )
        },
        selectedContentColor = BlueRibbon,
        unselectedContentColor = GraySilverChalice,
        selected = selected,
        onClick = onClick
    )
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false