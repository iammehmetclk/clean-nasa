package com.nasa.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Content(
    val roverName: String,
    val roverStatus: String,
    val roverLaunchDate: String,
    val roverLandingDate: String,
    val imageUrl: String,
    val imageCamera: String,
) : Parcelable