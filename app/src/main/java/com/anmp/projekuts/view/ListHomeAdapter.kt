package com.anmp.projekuts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.anmp.projekuts.R
import com.anmp.projekuts.model.Rumah
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_list_home.view.*

class ListHomeAdapter(val homelist: ArrayList<Rumah>) :
    RecyclerView.Adapter<ListHomeAdapter.HomeViewHolder>() {
    class HomeViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType:
        Int
    ): HomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.fragment_list_home, parent, false)
        return HomeViewHolder(view)

    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.view.txtNama.text=homelist[position].namaRumah
        holder.view.txtAlamat.text=homelist[position].alamatRumah
        holder.view.txtJarak.text="Jarak : "+homelist[position].jarak+" km"
        holder.view.txtHarga.text="Rp. "+homelist[position].hargaRumah+"/bulan"

        Picasso.get().load(homelist[position].photo).into(holder.view.imageView)
        holder.view.btnDetail.setOnClickListener {
            val action=HomeFragmentDirections.actionItemHomeToDetailHomeListFragment(homelist[position].id.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return homelist.size
    }
    fun updateHomeList(newHomeList: ArrayList<Rumah>) {
        homelist.clear()
        homelist.addAll(newHomeList)
        notifyDataSetChanged()
    }
}