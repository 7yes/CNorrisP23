package com.example.cnorrisp.ui.frags

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.view.isNotEmpty
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cnorrisp.R
import com.example.cnorrisp.core.hideKeyboard
import com.example.cnorrisp.data.adapter.ChuckAdapter
import com.example.cnorrisp.databinding.FragmentQueryBinding
import com.example.cnorrisp.ui.states.UIState
import com.example.cnorrisp.viewmodel.ChuckVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QueryFragment : Fragment(), SearchView.OnQueryTextListener {
    private var _binding: FragmentQueryBinding? = null
    private val binding get() = _binding!!
    private val viewmodel: ChuckVM by activityViewModels()

    lateinit var adapter: ChuckAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQueryBinding.inflate(layoutInflater, container, false)

        initRV()
        viewmodel.stateList.observe(viewLifecycleOwner) {
            when (it) {
                is UIState.Error -> {
                    binding.progress.isVisible = false
                    AlertDialog.Builder(requireContext())
                        .setTitle(getString(R.string.error))
                        .setMessage(it.e.localizedMessage)
                        .show()
                }

                UIState.Loading -> {
                    binding.progress.isVisible = true
                }

                UIState.Success -> {
                    binding.progress.isVisible = false
                    updateRVData()
                }
            }
        }
        binding.svQuery.setOnQueryTextListener(this)
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun initRV() {
        binding.rvQuery.layoutManager = LinearLayoutManager(requireContext())
       // updateRVData()
    }

    private fun updateRVData() {
        val jokes: List<String> = viewmodel.lastList.value ?: emptyList()
        Log.d("TAG", "initRV: lista $jokes")
        adapter = ChuckAdapter(jokes)
        binding.rvQuery.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onQueryTextSubmit(p0: String): Boolean {
        if(binding.svQuery.isNotEmpty()){
            viewmodel.getQuery(p0.lowercase())
            hideKeyboard()
        }
        return true
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        return true
    }
}
