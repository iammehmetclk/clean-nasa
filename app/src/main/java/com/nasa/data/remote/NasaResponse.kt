package com.nasa.data.remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.nasa.data.remote.model.Photo
import kotlinx.parcelize.Parcelize

@Parcelize
data class NasaResponse(
    @SerializedName("photos")
    val photos: List<Photo>?,
) : Parcelable