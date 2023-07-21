package com.anmp.projekuts.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.anmp.projekuts.model.Rumah
import com.anmp.projekuts.model.RumahDatabase
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailViewModel (application: Application): AndroidViewModel(application),CoroutineScope {

    val homeLD = MutableLiveData<Rumah>()
    private var job= Job()

    override val coroutineContext: CoroutineContext
        get() = job+ Dispatchers.IO
    fun fetch(id: Int) {
            launch {
                val db= Room.databaseBuilder(getApplication(), RumahDatabase::class.java,"rumah").build()
                homeLD.postValue(db.rumahDao().selectDetailRumah(id))

            }
    }

}