package com.omar.guerrero.kotlin.kotlincertification


object MediaProvider {

    private const val thumbBase = "https://loremflickr.com/320/240?random="

    val getDataSource = (1..10).map {
            MediaItem(
                it,"Title $it", "${thumbBase}$it",
                if (it % 2 == 0) MediaItem.Type.PHOTO else MediaItem.Type.VIDEO
            )
        }
}