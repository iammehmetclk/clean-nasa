package com.nasa.presentation

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.nasa.presentation.custom_view.ToolbarView

@BindingAdapter("setToolbarTitle", requireAll = true)
fun setToolbarTitle(toolbarView: ToolbarView, title: String) {
    toolbarView.title = title
}

@BindingAdapter("setImageUrl", requireAll = true)
fun setImageUrl(imageView: ImageView, imageUrl: String) {
    Glide.with(imageView).load(imageUrl).into(imageView)
}

@BindingAdapter("setLaunchDate", requireAll = true)
fun setLaunchDate(textView: TextView, launchDate: String) {
    textView.text = "Launch Date: $launchDate"
}

@BindingAdapter("setLandingDate", requireAll = true)
fun setLandingDate(textView: TextView, landingDate: String) {
    textView.text = "Landing Date: $landingDate"
}

@BindingAdapter("setStatus", requireAll = true)
fun setStatus(textView: TextView, status: String) {
    textView.text = "Status: $status"
}

@BindingAdapter("setCamera", requireAll = true)
fun setCamera(textView: TextView, camera: String) {
    textView.text = "Camera: $camera"
}