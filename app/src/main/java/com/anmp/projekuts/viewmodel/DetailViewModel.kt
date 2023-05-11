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

class DetailViewModel (application: Application): AndroidViewModel(application) {
    val homeLD = MutableLiveData<Rumah>()
    val TAG = "detailhome"
    private var queue: RequestQueue? = null
    fun fetch(id: String) {

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://192.168.100.43/projekanmp/detailkos.php?id=" + id
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val result = Gson().fromJson<Rumah>(it, Rumah::class.java)
                homeLD.value = result
                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
                homeLD.value = null
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)

    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}