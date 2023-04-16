package com.fossil.galleryapp.core.common.network

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val gaDispatchers: GaDispatchers)

enum class GaDispatchers {
    IO
}
