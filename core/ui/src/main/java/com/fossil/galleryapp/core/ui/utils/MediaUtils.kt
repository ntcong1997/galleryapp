package com.fossil.galleryapp.core.ui.utils

import java.text.DecimalFormat

/**
 * Created by TC on 16/04/2023.
 */

object MediaUtils {
    fun formatToFileSize(size: Long): String {
        if (size <= 0) return ""
        else {
            val b = size
            val k = size / 1024.0
            val m = size / 1024.0 / 1024.0
            val g = size / 1024.0 / 1024.0 / 1024.0
            val t = size / 1024.0 / 1024.0 / 1024.0 / 1024.0

            val dec = DecimalFormat("0.00")

            return when {
                t > 1 -> {
                    dec.format(t) + " TB"
                }
                g > 1 -> {
                    dec.format(g) + " GB"
                }
                m > 1 -> {
                    dec.format(m) + " MB"
                }
                k > 1 -> {
                    dec.format(k) + " KB"
                }
                else -> {
                    dec.format(b) + " Bytes"
                }
            }
        }
    }
}