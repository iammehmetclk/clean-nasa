package com.nasa.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.nasa.R
import com.nasa.databinding.FragmentHomeTabBinding
import com.nasa.domain.model.Content
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeTabFragment : Fragment(R.layout.fragment_home_tab), IHome {

    var type = HomeTabType.CURIOSITY

    private lateinit var binding: FragmentHomeTabBinding
    private val viewModel: HomeViewModel by viewModels()
    private val adapter = HomeContentAdapter(this)
    private var solIndex = 1
    private var pageIndex = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeTabBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getContent()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        subscribeObservables()
    }

    override fun onLoadMore() {
        getContent()
    }

    override fun onItemClick(content: Content) {
        findNavController().navigate(HomeFragmentDirections.actionHomeToDetail(content))
    }

    private fun setRecyclerView() {
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.recyclerView.adapter = adapter
    }

    private fun subscribeObservables() {
        lifecycleScope.launch {
            viewModel.state.collect { state ->
                state.loading?.let {
                    binding.progressBar.visibility = View.VISIBLE
                    viewModel.clearState()
                }
                state.contents?.let { safeContents ->
                    if (safeContents.isEmpty()) {
                        solIndex++
                        pageIndex = 1
                        getContent()
                    } else {
                        pageIndex++
                        adapter.submitList(safeContents)
                    }
                    binding.progressBar.visibility = View.GONE
                    viewModel.clearState()
                }
                state.message?.let { safeMessage ->
                    Snackbar.make(binding.root, safeMessage, Snackbar.LENGTH_LONG)
                        .setAction("Try Again") { getContent() }.show()
                    binding.progressBar.visibility = View.GONE
                    viewModel.clearState()
                }
            }
        }
    }

    private fun getContent() {
        when (type) {
            HomeTabType.CURIOSITY -> viewModel.getCuriosity(solIndex, pageIndex)
            HomeTabType.OPPORTUNITY -> viewModel.getOpportunity(solIndex, pageIndex)
            HomeTabType.SPIRIT -> viewModel.getSpirit(solIndex, pageIndex)
        }
    }

}