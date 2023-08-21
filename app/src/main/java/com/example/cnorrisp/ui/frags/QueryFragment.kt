package com.example.cnorrisp.ui.frags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cnorrisp.databinding.FragmentQueryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QueryFragment : Fragment() {
    private var _binding: FragmentQueryBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQueryBinding.inflate(layoutInflater, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
