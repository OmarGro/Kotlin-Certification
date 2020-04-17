package com.omar.guerrero.kotlin.kotlincertification

sealed class Filter{
    object None : Filter()
    class ByType(val type : MediaItem.Type) : Filter()
}