package com.anmp.projekuts.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.anmp.projekuts.model.Rumah
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ViewModelList (application: Application): AndroidViewModel(application) {
    val homeLD = MutableLiveData<ArrayList<Rumah>>()
    val TAG="allTag"
    private var queue: RequestQueue? = null

    fun refresh() {
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://192.168.100.43/projekanmp/listKos.php"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<Rumah>>() { }.type
                val result = Gson().fromJson<List<Rumah>>(it, sType)
                homeLD.value = result as ArrayList<Rumah>?
                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)

    }
    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }

}