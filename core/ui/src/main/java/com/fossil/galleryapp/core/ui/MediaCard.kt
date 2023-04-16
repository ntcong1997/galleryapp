package com.fossil.galleryapp.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.decode.VideoFrameDecoder
import com.fossil.galleryapp.core.designsystem.icon.GaIcons
import com.fossil.galleryapp.core.designsystem.theme.Transparent30
import com.fossil.galleryapp.core.model.Media
import com.fossil.galleryapp.core.model.MediaType
import com.fossil.galleryapp.core.ui.utils.MediaUtils
import java.text.SimpleDateFormat
import java.util.Locale

/**
 * Created by TC on 16/04/2023.
 */

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MediaCard(
    media: Media
) {
    Card(
        onClick = {},
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            MediaPreview(path = media.path, type = media.type)

            Spacer(modifier = Modifier.width(10.dp))

            Column(modifier = Modifier.fillMaxWidth()) {
                MediaName(name = media.name)

                Spacer(modifier = Modifier.height(4.dp))

                Row(modifier = Modifier.fillMaxWidth()) {
                    MediaLastModified(lastModified = media.lastModified)

                    Spacer(modifier = Modifier.width(8.dp))

                    MediaSize(size = media.size)
                }
            }
        }
    }
}

@Composable
fun MediaPreview(
    path: String?,
    type: MediaType
) {
    when (type) {
        MediaType.PICTURE -> MediaPreviewPicture(path = path)
        MediaType.VIDEO -> MediaPreviewVideo(path = path)
    }
}

@Composable
fun MediaPreviewPicture(
    path: String?
) {
    AsyncImage(
        model = path,
        contentDescription = null,
        modifier = Modifier
            .size(100.dp)
    )
}

@Composable
fun MediaPreviewVideo(
    path: String?
) {
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            add(VideoFrameDecoder.Factory())
        }.crossfade(true)
        .build()

    val painter = rememberAsyncImagePainter(
        model = path,
        imageLoader = imageLoader
    )

    Box(
        modifier = Modifier
            .size(100.dp)
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
        )

        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .background(Transparent30, CircleShape)
        ) {
            Icon(
                imageVector = GaIcons.Play,
                contentDescription = null,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun MediaName(
    name: String?
) {
    Text(
        text = name.orEmpty(),
        fontSize = 16.sp
    )
}

@Composable
fun RowScope.MediaLastModified(
    lastModified: Long?
) {
    val lastModified =
        SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.getDefault()).format(lastModified ?: 0L)
    Text(
        text = lastModified,
        fontSize = 14.sp,
        modifier = Modifier.weight(1f)
    )
}

@Composable
fun MediaSize(
    size: Long?
) {
    val size = MediaUtils.formatToFileSize(size ?: 0L)
    Text(
        text = size,
        fontSize = 14.sp
    )
}