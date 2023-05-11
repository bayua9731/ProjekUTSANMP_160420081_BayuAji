package com.anmp.projekuts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.anmp.projekuts.R
import com.anmp.projekuts.viewmodel.DetailViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail_home_list.*


class DetailHomeListFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_home_list, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {
            val id = DetailHomeListFragmentArgs.fromBundle(requireArguments()).idhome
            viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
            viewModel.fetch(id)

            observeViewModel()

        }

    }
    fun observeViewModel(){
        viewModel.homeLD.observe(viewLifecycleOwner, Observer {
            Picasso.get().load(it.photo.toString()).into(imageView3)
            txtDetailNamaRumah.editText?.setText(it.namaRumah)
            txtDetailAlamatRUmah.editText?.setText(it.alamatRumah)
            txtDetailDeskripsi.editText?.setText(it.deskripsi)
            txtDetailJarakRumah.editText?.setText(it.jarak+" km")
            txtDetailHargaRumah.editText?.setText("Rp. "+it.hargaRumah+"/bulan")
            txtDetailKategori.editText?.setText(it.kategori)
            txtDetailNamaPemilik.editText?.setText(it.pemilikRumah)
            txtDetailKontak.editText?.setText(it.nomorTelepon)
        })
    }
}