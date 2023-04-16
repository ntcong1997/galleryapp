package com.fossil.galleryapp.core.ui

import androidx.compose.foundation.lazy.LazyListScope
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.fossil.galleryapp.core.model.Media
import java.util.UUID

/**
 * Created by TC on 16/04/2023.
 */

fun LazyListScope.mediaCardItems(
    items: LazyPagingItems<Media>
) = items(
    items = items,
    key = { it.id ?: UUID.randomUUID().toString() },
    itemContent = {
        it?.let {
            MediaCard(media = it)
        }
    }
)