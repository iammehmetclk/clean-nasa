package com.nasa.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nasa.databinding.ListItemContentBinding
import com.nasa.domain.model.Content

class HomeContentAdapter(
    private val listener: IHome,
) : ListAdapter<Content, HomeContentAdapter.ViewHolder>(CONTENT_COMPARATOR) {

    private var contents: List<Content> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(contents[position])
        if (position == contents.size - 1) {
            listener.onLoadMore()
        }
    }

    inner class ViewHolder(private val binding: ListItemContentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Content) {
            Glide.with(binding.root).load(item.imageUrl).into(binding.imageView)
            binding.cardView.setOnClickListener {
                listener.onItemClick(item)
            }
        }
    }

    override fun submitList(list: List<Content>?) {
        list?.let { safeList ->
            val temp = contents + safeList
            contents = temp
            super.submitList(contents)
        }
    }

    companion object {
        private val CONTENT_COMPARATOR = object : DiffUtil.ItemCallback<Content>() {
            override fun areItemsTheSame(oldItem: Content, newItem: Content): Boolean {
                return oldItem.imageUrl == newItem.imageUrl
            }
            override fun areContentsTheSame(oldItem: Content, newItem: Content): Boolean {
                return oldItem == newItem
            }
        }
    }

}