package com.nasa.presentation.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.DrawableRes
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.appbar.MaterialToolbar
import com.nasa.R
import com.nasa.databinding.LayoutToolbarBinding

class ToolbarView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet,
    defStyleAttr: Int = 0,
) : MaterialToolbar(context, attributeSet, defStyleAttr) {

    private val binding = LayoutToolbarBinding.inflate(LayoutInflater.from(context), this, true)

    var title: String = ""
        set(value) {
            field = value
            binding.tvTitle.text = value
        }

    @DrawableRes
    private var rightIcon: Int = 0
        set(value) {
            field = value
            if (value == 0) {
                binding.clRightIcon.visibility = INVISIBLE
            } else {
                binding.clRightIcon.visibility = VISIBLE
                binding.ivRightIcon.setImageDrawable(
                    ResourcesCompat.getDrawable(context.resources, value, null)
                )
            }
        }

    @DrawableRes
    private var leftIcon: Int = 0
        set(value) {
            field = value
            if (value == 0) {
                binding.clLeftIcon.visibility = INVISIBLE
            } else {
                binding.clLeftIcon.visibility = VISIBLE
                binding.ivLeftIcon.setImageDrawable(
                    ResourcesCompat.getDrawable(context.resources, value, null)
                )
            }
        }

    init {
        val typedArray = context.theme.obtainStyledAttributes(
            attributeSet,
            R.styleable.ToolbarView,
            0,
            0
        )
        try {
            title = typedArray.getString(R.styleable.ToolbarView_toolbar_view_title) ?: context.getString(R.string.app_name)
            rightIcon = typedArray.getResourceId(R.styleable.ToolbarView_toolbar_view_right_icon, 0)
            leftIcon = typedArray.getResourceId(R.styleable.ToolbarView_toolbar_view_left_icon, 0)
        } finally {
            typedArray.recycle()
        }
    }

    fun setRightIconListener(listener: () -> Unit) {
        binding.clRightIcon.setOnClickListener {
            listener.invoke()
        }
    }

    fun setLeftIconListener(listener: () -> Unit) {
        binding.clLeftIcon.setOnClickListener {
            listener.invoke()
        }
    }

}