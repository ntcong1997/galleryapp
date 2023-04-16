package com.fossil.galleryapp.core.storage

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import com.fossil.galleryapp.core.model.Media
import com.fossil.galleryapp.core.model.MediaType
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import javax.inject.Inject

/**
 * Created by TC on 16/04/2023.
 */

interface GaStorage {
    suspend fun getPictures(prevIndex: Int, pageSize: Int) : List<Media>
    suspend fun getVideos(prevIndex: Int, pageSize: Int) : List<Media>
}

class DefaultGaStorage @Inject constructor(
    @ApplicationContext private val context: Context
) : GaStorage {
    override suspend fun getPictures(prevIndex: Int, pageSize: Int): List<Media> {
        return getMedia(prevIndex, pageSize, MediaType.PICTURE)
    }

    override suspend fun getVideos(prevIndex: Int, pageSize: Int): List<Media> {
        return getMedia(prevIndex, pageSize, MediaType.VIDEO)
    }

    private fun getMedia(prevIndex: Int, pageSize: Int, type: MediaType) : List<Media> {
        val media = ArrayList<Media>()
        val uri: Uri = when (type) {
            MediaType.PICTURE -> MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            MediaType.VIDEO -> MediaStore.Video.Media.EXTERNAL_CONTENT_URI
        }
        val projection = arrayOf(
            "_id",
            MediaStore.MediaColumns.DATA
        )
        val cursor = context.contentResolver.query(
            uri,
            projection,
            null,
            null,
            "${MediaStore.Images.ImageColumns.DATE_MODIFIED} DESC"
        )

        cursor?.moveToPosition(prevIndex)
        while (cursor?.moveToNext() == true && cursor.position < (prevIndex + pageSize)) {
            val data = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA))
            val file = File(data)
            if (file.exists()) {
                val id = cursor.getString(cursor.getColumnIndexOrThrow("_id"))
                media.add(Media(
                    id = id,
                    name = file.name,
                    path = file.absolutePath,
                    size = file.length(),
                    lastModified = file.lastModified(),
                    type = type
                ))
            }
        }
        cursor?.close()

        return media
    }
}
