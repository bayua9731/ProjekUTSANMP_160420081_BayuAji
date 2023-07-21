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
import com.anmp.projekuts.viewmodel.FilterViewModel
import kotlinx.android.synthetic.main.fragment_filter.*


class SewaFragment : Fragment() {
    private lateinit var viewModel: FilterViewModel
    private val homeListAdapter = FilterPutraAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sewa, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(FilterViewModel::class.java)
        viewModel.refresh("sewa")
        recViewPutra.layoutManager = LinearLayoutManager(context)
        recViewPutra.adapter = homeListAdapter
        observeViewModel()
    }
    fun observeViewModel() {
        viewModel.homeLD.observe(viewLifecycleOwner, Observer {
            homeListAdapter.updateHomeList(it)
        })
    }
}