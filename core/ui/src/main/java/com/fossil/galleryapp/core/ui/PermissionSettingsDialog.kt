package com.fossil.galleryapp.core.ui

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

/**
 * Created by TC on 16/04/2023.
 */

@Composable
fun PermissionSettingsDialog(
    onSettingsClick: () -> Unit,
    onDismissRequest: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        text = {
            Text(text = stringResource(id = R.string.content_permission_settings))
        },
        confirmButton = {
            TextButton(onClick = onSettingsClick) {
                Text(text = stringResource(id = R.string.action_settings))
            }
        },
        dismissButton = {
            TextButton(onClick = onDismissRequest) {
                Text(text = stringResource(id = R.string.action_cancel))
            }
        }
    )
}