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
import com.example.cnorrisp.databinding.FragmentRandomBinding
import com.example.cnorrisp.ui.states.UIState
import com.example.cnorrisp.viewmodel.ChuckVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RandomFragment : Fragment() {
    private var _binding: FragmentRandomBinding? = null
    private val binding get() = _binding!!
    private val viewmodel: ChuckVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRandomBinding.inflate(layoutInflater, container, false)

        viewmodel.lastRandom.observeForever {
            binding.tvRandomJoke.text = it
        }

        binding.root.setOnClickListener {
            viewmodel.getRandom()
        }
        if (binding.tvRandomJoke.text.isEmpty()) viewmodel.getRandom()

        viewmodel.stateRandom.observe(viewLifecycleOwner) {
            when (it) {
                is UIState.Error -> AlertDialog.Builder(requireContext())
                    .setTitle(getString(R.string.error))
                    .setMessage(it.e.localizedMessage)
                    .show()

                UIState.Loading -> binding.progress.isVisible = true
                UIState.Success -> binding.progress.isVisible = false
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
