package com.example.cnorrisp.ui.frags

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.cnorrisp.R
import com.example.cnorrisp.core.hideKeyboard
import com.example.cnorrisp.databinding.FragmentCustomBinding
import com.example.cnorrisp.ui.states.UIState
import com.example.cnorrisp.viewmodel.ChuckVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CustomFragment : Fragment() {
    private var _binding: FragmentCustomBinding? = null
    private val binding get() = _binding!!
    private val viewmodel: ChuckVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCustomBinding.inflate(layoutInflater, container, false)

        binding.btnSend.setOnClickListener {
            viewmodel.getCustom(binding.etCustom.text.toString())
            hideKeyboard()
        }

        viewmodel.lastCustom.observeForever { binding.tvCustomJoke.text = it }

        viewmodel.stateCustom.observe(viewLifecycleOwner) {
            when (it) {
                is UIState.Error -> AlertDialog.Builder(requireContext())
                    .setTitle(getString(R.string.error))
                    .setMessage(it.e.localizedMessage)
                    .show()

                UIState.Loading -> binding.progress.isVisible = true
                UIState.Success -> binding.progress.isVisible = false
            }
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
