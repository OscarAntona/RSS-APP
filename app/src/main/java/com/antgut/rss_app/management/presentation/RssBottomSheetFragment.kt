package com.antgut.rss_app.management.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.antgut.app.extensions.showBar
import com.antgut.app.serializer.GsonSerializer
import com.antgut.rss_app.R
import com.antgut.rss_app.databinding.RssBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

class RssBottomSheetFragment : BottomSheetDialogFragment() {

    private var binding: RssBottomSheetBinding? = null
    private val viewModel by lazy {
        this.activity?.let {
            RssManagerFactory().saveUserRss(
                it.getPreferences(Context.MODE_PRIVATE),
                GsonSerializer()
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RssBottomSheetBinding.inflate(inflater)
        setupView()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObserver()
    }

    private fun setupView() {
        binding?.apply {
            saveButton.setOnClickListener {
                viewModel?.saveRss(
                    inputUrl.text.toString(),
                    inputName.text.toString()
                )
                findNavController().navigateUp()
            }
            binding?.cancelButton?.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    private fun setUpObserver() {
        val subscriber = Observer<RssManagerViewModel.RssManagerUiState> {
            if (it.isSuccess)
                requireActivity().findViewById<View>(R.id.fragment_container_view)
                    .showBar(getString(R.string.success_saving))
            else {
                requireActivity().findViewById<View>(R.id.fragment_container_view)
                    .showBar(getString(R.string.error_saving))
            }
        }

        viewModel?.managerPublisher?.observe(viewLifecycleOwner, subscriber)

    }
}