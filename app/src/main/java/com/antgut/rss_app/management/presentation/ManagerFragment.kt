package com.antgut.rss_app.management.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.antgut.app.serializer.GsonSerializer
import com.antgut.app.snackbar.showSnackbar
import com.antgut.rss_app.R
import com.antgut.rss_app.databinding.FragmentManagerBinding
import com.antgut.rss_app.management.data.local.datastore.DataStoreLocalDataSource
import com.antgut.rss_app.management.presentation.adapter.ManagerAdapter
import com.faltenreich.skeletonlayout.Skeleton
import com.faltenreich.skeletonlayout.applySkeleton

class ManagerFragment : Fragment() {

    var binding: FragmentManagerBinding? = null
    var skeleton: Skeleton? = null
    var rssAdapter = ManagerAdapter()
    val viewModel by lazy {
        this.activity?.let {
            DataStoreFactory().injectViewModel(
                requireContext()
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentManagerBinding.inflate(inflater)
        setupBottomSheet()
        setupView()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel?.obtainUserRssList()
    }

    fun setupBottomSheet() {
        binding?.rssManagerToolbar?.apply {
            title = getString(R.string.manager_fragment_title)
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.action_add_rss -> showBottomSheet()
                }
                true
            }
        }
    }

    fun showBottomSheet() {
        findNavController().navigate(ManagerFragmentDirections.actionToBottomSheet())
    }

    fun setupView() {
        binding?.apply {
            feedListRecyclerView.adapter = rssAdapter
            feedListRecyclerView.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            skeleton = feedListRecyclerView.applySkeleton(R.layout.fragment_feed)
            rssAdapter.setOnClick{viewModel?.deleteUserRss(it)
                showSnackbar(getString(R.string.deleted),requireActivity().findViewById(R.id.fragment_container_view))
            }
        }
    }

    fun setupObservers() {
        val feedSubscriber =
            Observer<RssDataStoreViewModel.UiState> { uiState ->
                if (uiState.isLoading) {
                    skeleton?.showSkeleton()
                } else {
                    skeleton?.showOriginal()
                    uiState.userRssList?.let{rssAdapter?.setDataItems(it)}
                }
            }
        viewModel?.uiState?.observe(viewLifecycleOwner, feedSubscriber)
    }


}