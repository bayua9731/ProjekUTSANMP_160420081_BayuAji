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
import com.anmp.projekuts.model.Rumah
import com.anmp.projekuts.model.Users
import com.anmp.projekuts.viewmodel.FilterViewModel
import com.anmp.projekuts.viewmodel.RegisterViewModel
import com.anmp.projekuts.viewmodel.ViewModelList
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_register.*

class HomeFragment : Fragment() {
    private lateinit var viewModel: ViewModelList
    private val homeListAdapter = ListHomeAdapter(arrayListOf())

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
        val rumah= Rumah("Kost AM 12",
            "Jl. Tenggilis Mejoyo Blok AM No.12, Kali Rungkut, Kec. Rungkut, Surabaya, Jawa Timur 60293",
            "500000",
            "https://lh5.googleusercontent.com/p/AF1QipMqNTAyOMvaqGJCutFaQgNscRlhyiqbdSqwNA3y=w253-h337-k-no",
            "Agus",
            "123123123",
            "1",

            "Kamar Mandi Dalam,Laundry,Area Parkiran Luas,WIFI,Token PLN,Dapur,Dekat Ubaya",
            "Putra",
            )
        viewModel.add(listOf(rumah))
            viewModel.refresh()

            recView.layoutManager = LinearLayoutManager(context)
            recView.adapter = homeListAdapter
            observeViewModel()
            btnFilter.setOnClickListener {
                val action=HomeFragmentDirections.actionItemHomeToFilterFragment()
                Navigation.findNavController(it).navigate(action)
            }
            btnFilter2.setOnClickListener {
                val action=HomeFragmentDirections.actionItemHomeToFIlterPutriFragment()
                Navigation.findNavController(it).navigate(action)
            }

            btnSort.setOnClickListener {
                val action=HomeFragmentDirections.actionItemHomeToSortByFragment()
                Navigation.findNavController(it).navigate(action)
            }

        btnSort2.setOnClickListener {
            val action=HomeFragmentDirections.actionItemHomeToTermurahFragment()
            Navigation.findNavController(it).navigate(action)
        }


    }

    fun observeViewModel() {
        viewModel.homeLD.observe(viewLifecycleOwner, Observer {
            homeListAdapter.updateHomeList(it)
        })
    }
}