package com.anmp.projekuts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.anmp.projekuts.R
import com.anmp.projekuts.viewmodel.SearchViewModel
import com.anmp.projekuts.viewmodel.SortViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {
    private lateinit var viewModel: SearchViewModel
    private val homeListAdapter = SearchAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSearchRumah.setOnClickListener {
            val temp=txtSearchRumah.text
            viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
            viewModel.refresh(temp.toString())
            recViewSearch.layoutManager = LinearLayoutManager(context)
            recViewSearch.adapter = homeListAdapter
            observeViewModel()
        }
    }
    fun observeViewModel() {
        viewModel.homeLD.observe(viewLifecycleOwner, Observer {
            homeListAdapter.updateHomeList(it)
        })
    }

}