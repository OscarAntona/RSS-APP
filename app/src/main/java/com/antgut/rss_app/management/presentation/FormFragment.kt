package com.antgut.rss_app.management.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.antgut.app.serializer.GsonSerializer
import com.antgut.app.snackbar.showSnackbar
import com.antgut.rss_app.R
import com.antgut.rss_app.databinding.FragmentUserFormBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FormFragment : BottomSheetDialogFragment() {

    var binding: FragmentUserFormBinding? = null
    val viewModel by lazy {
        this.activity?.let {
            FormFactory().saveUserRss(
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
        binding = FragmentUserFormBinding.inflate(inflater)
        setupView()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObserver()
    }
    fun setupView() {
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
        val subscriber = Observer<FormViewModel.RssManagerUiState> {
            if (it.isSuccess)
                requireActivity().findViewById<View>(R.id.fragment_container_view)
                    .showSnackbar(getString(R.string.success_saving))
            else {
                requireActivity().findViewById<View>(R.id.fragment_container_view)
                    .showSnackbar(getString(R.string.error_saving))
            }
        }

        viewModel?.rssManagerPublisher?.observe(viewLifecycleOwner, subscriber)

    }
}