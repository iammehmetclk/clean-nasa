package com.nasa.data.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Camera(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("rover_id")
    val roverId: Int?,
    @SerializedName("full_name")
    val fullName: String?,
) : Parcelable