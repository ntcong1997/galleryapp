package com.fossil.galleryapp.core.model

/**
 * Created by TC on 16/04/2023.
 */

data class Media(
    val id: String?,
    val name: String?,
    val path: String?,
    val size: Long?,
    val lastModified: Long?,
    val type: MediaType
)

enum class MediaType(
    val value: String
) {
    PICTURE("picture"),
    VIDEO("video")
}