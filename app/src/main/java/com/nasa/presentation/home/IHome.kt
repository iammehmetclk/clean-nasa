package com.nasa.presentation.home

import com.nasa.domain.model.Content

interface IHome {

    fun onItemClick(content: Content)

    fun onLoadMore()

}