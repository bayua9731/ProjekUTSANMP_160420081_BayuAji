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
import com.anmp.projekuts.viewmodel.TermurahViewModel
import kotlinx.android.synthetic.main.fragment_sort_by.*
import kotlinx.android.synthetic.main.fragment_termurah.*


class TermurahFragment : Fragment() {
    private lateinit var viewModel: TermurahViewModel
    private val homeListAdapter = TermurahAdapter(arrayListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_termurah, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(TermurahViewModel::class.java)
        viewModel.refresh()
        recViewMurah.layoutManager = LinearLayoutManager(context)
        recViewMurah.adapter = homeListAdapter
        observeViewModel()
    }
    fun observeViewModel() {
        viewModel.homeLD.observe(viewLifecycleOwner, Observer {
            homeListAdapter.updateHomeList(it)
        })
    }

}