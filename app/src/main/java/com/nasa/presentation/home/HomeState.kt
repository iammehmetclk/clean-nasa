package com.nasa.presentation.home

import android.os.Parcelable
import com.nasa.domain.model.Content
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeState(
    val loading: Boolean?,
    val contents: List<Content>?,
    val message: String?,
) : Parcelable