package com.antgut.rss_app.management.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
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

    private fun setupView() {
        binding?.apply {
            saveButton.setOnClickListener {
                viewModel?.saveRss(
                    inputUrl.text.toString(),
                    inputName.text.toString()
                )
                findNavController().navigateUp()
                showBar()
            }
            binding?.cancelButton?.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    private fun showBar() {
        Snackbar.make(
            (requireActivity()).findViewById<ViewGroup>(R.id.main_view),
            "Guardado",
            BaseTransientBottomBar.LENGTH_SHORT
        ).show()
    }

}