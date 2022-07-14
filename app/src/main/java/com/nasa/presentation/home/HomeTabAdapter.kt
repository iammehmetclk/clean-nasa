package com.nasa.presentation.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeTabAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return HomeTabType.values().size
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = HomeTabFragment()
        fragment.type = HomeTabType.values()[position]
        return fragment
    }

}