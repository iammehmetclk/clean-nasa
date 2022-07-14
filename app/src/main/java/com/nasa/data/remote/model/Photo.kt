package com.nasa.data.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Photo(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("sol")
    val sol: Int?,
    @SerializedName("camera")
    val camera: Camera?,
    @SerializedName("img_src")
    val imageUrl: String?,
    @SerializedName("earth_date")
    val date: String?,
    @SerializedName("rover")
    val rover: Rover?,
) : Parcelable