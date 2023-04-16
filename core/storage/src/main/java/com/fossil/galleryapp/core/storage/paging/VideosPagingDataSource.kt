package com.fossil.galleryapp.core.storage.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.fossil.galleryapp.core.model.Media

/**
 * Created by TC on 16/04/2023.
 */

class VideosPagingDataSource(
    private val onGetVideos: suspend (Int, Int) -> List<Media>
) : PagingSource<Int, Media>() {
    override fun getRefreshKey(state: PagingState<Int, Media>): Int {
        return -1
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Media> {
        val position = params.key ?: -1
        return try {
            val response = onGetVideos(position, params.loadSize)
            LoadResult.Page(
                data = response,
                prevKey = null, // Only paging forward.
                nextKey = if (response.isEmpty()) null else position + params.loadSize
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}