package com.coldfier.mynutrition3.searchfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.coldfier.mynutrition3.R
import com.coldfier.mynutrition3.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var viewModel: SearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSearchBinding.bind(inflater.inflate(R.layout.fragment_search, container, false))

        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        val rvAdapter = SearchFragmentRVAdapter()
        binding.resultsRecyclerView.adapter = rvAdapter
        binding.resultsRecyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.foodList.observe(viewLifecycleOwner, {
                rvAdapter.foodList = it
        })

        binding.searchButton.setOnClickListener{
            viewModel.getFood(binding.searchEditText.text.toString())
        }

        return binding.root
    }

}