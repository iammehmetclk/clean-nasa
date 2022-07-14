package com.nasa.presentation.custom_view

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import com.nasa.R
import com.nasa.databinding.DialogContentBinding

class ContentDialog(context: Context, url: String) {

    private val dialog = Dialog(context, R.style.DialogTheme)
    private val binding = DialogContentBinding.inflate(LayoutInflater.from(context), null, false)

    init {
        Glide.with(context).load(url).into(binding.imageView)
        binding.imageViewClose.setOnClickListener {
            if (dialog.isShowing) {
                dialog.dismiss()
            }
        }
        dialog.setContentView(binding.root)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()
    }

}