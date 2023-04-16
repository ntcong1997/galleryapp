package com.fossil.galleryapp.core.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

/**
 * Created by TC on 16/04/2023.
 */

fun LazyListScope.permissionItem(
    content: String,
    onAllowClick: () -> Unit
) {
    item {
        Column(
            modifier = Modifier
                .fillParentMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = content)

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onAllowClick,
                shape = RoundedCornerShape(50.dp),
                contentPadding = PaddingValues(16.dp)
            ) {
                Text(text = stringResource(id = R.string.action_allow))
            }
        }
    }
}