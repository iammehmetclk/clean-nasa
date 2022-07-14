package com.nasa.data.mapper

import com.nasa.data.remote.NasaResponse
import com.nasa.domain.model.Content

fun NasaResponse.toContentList(): List<Content> {
    val list = arrayListOf<Content>()
    this.photos?.let { safeList ->
        for (item in safeList) {
            list.add(
                Content(
                    roverName = item.rover?.name ?: "",
                    roverStatus = item.rover?.status ?: "",
                    roverLaunchDate = item.rover?.launchDate ?: "",
                    roverLandingDate = item.rover?.landingDate ?: "",
                    imageUrl = item.imageUrl ?: "",
                    imageCamera = item.camera?.name ?: "",
                )
            )
        }
    }
    return list
}
