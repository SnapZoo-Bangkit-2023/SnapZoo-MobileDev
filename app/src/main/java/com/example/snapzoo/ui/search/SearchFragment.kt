package com.example.snapzoo.ui.search

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.snapzoo.adapter.AnimalAdapter
import com.example.snapzoo.databinding.FragmentSearchBinding
import com.example.snapzoo.model.AnimalResponse
import com.example.snapzoo.ui.detail.DetailActivity


class SearchFragment : Fragment()  {

    companion object {
        const val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var binding: FragmentSearchBinding
    private lateinit var animalAdapter: AnimalAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        initViewModel()
        showLoading(true)

        binding.searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                animalAdapter.filterList(newText)
                return true
            }
        })




        animalAdapter.setOnItemClickCallback(object : AnimalAdapter.OnItemClickCallback {
            @SuppressLint("SuspiciousIndentation")
            override fun onItemClick(data: AnimalResponse) {
                val intent = Intent(requireContext(), DetailActivity::class.java)
                    intent.putExtra(INTENT_PARCELABLE, data)
                    startActivity(intent)

            }

        })

    }

    private fun initRecyclerView() {
        binding.rvUser.layoutManager = LinearLayoutManager(requireContext())
        animalAdapter = AnimalAdapter()
        binding.rvUser.adapter = animalAdapter
    }

    private fun initViewModel() {
        val viewModel: SearchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        viewModel.getAnimalList().observe(viewLifecycleOwner, Observer { animalList ->
            if (animalList != null) {
                showLoading(false)
                animalAdapter.setList(animalList)
                animalAdapter.notifyDataSetChanged()
            } else {
                showLoading(false)
                Toast.makeText(requireContext(), "Error in getting list", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun showLoading(loading: Boolean) {
        when(loading) {
            true -> {
                binding.progressBar.visibility = View.VISIBLE
            }
            false -> {
                binding.progressBar.visibility = View.GONE
            }
        }
    }




}