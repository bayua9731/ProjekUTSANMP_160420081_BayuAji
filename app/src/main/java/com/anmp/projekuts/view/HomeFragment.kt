package com.anmp.projekuts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.anmp.projekuts.R
import com.anmp.projekuts.viewmodel.FilterViewModel
import com.anmp.projekuts.viewmodel.ViewModelList
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private lateinit var viewModel: ViewModelList
    private val studentListAdapter = ListHomeAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            viewModel = ViewModelProvider(this).get(ViewModelList::class.java)
            viewModel.refresh()
            recView.layoutManager = LinearLayoutManager(context)
            recView.adapter = studentListAdapter
            observeViewModel()
        btnFilter.setOnClickListener {
            val action=HomeFragmentDirections.actionItemHomeToFilterFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun observeViewModel() {
        viewModel.homeLD.observe(viewLifecycleOwner, Observer {
            studentListAdapter.updateHomeList(it)
        })
    }
}