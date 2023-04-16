package com.fossil.galleryapp.core.storage.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.fossil.galleryapp.core.model.Media
import com.fossil.galleryapp.core.storage.GaStorage

/**
 * Created by TC on 16/04/2023.
 */

class PicturesPagingDataSource(
    private val gaStorage: GaStorage
) : PagingSource<Int, Media>() {
    override fun getRefreshKey(state: PagingState<Int, Media>): Int {
        return -1
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Media> {
        val position = params.key ?: -1
        return try {
            val response = gaStorage.getPictures(position, params.loadSize)
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