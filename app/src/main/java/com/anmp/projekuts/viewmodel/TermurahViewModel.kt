package com.anmp.projekuts.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.anmp.projekuts.model.Rumah
import com.anmp.projekuts.model.RumahDatabase
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class TermurahViewModel(application: Application): AndroidViewModel(application) ,CoroutineScope{
    val homeLD=MutableLiveData<List<Rumah>>()
    private var job= Job()

    override val coroutineContext: CoroutineContext
        get() = job+ Dispatchers.IO

    fun refresh() {

        launch {
            val db= Room.databaseBuilder(getApplication(), RumahDatabase::class.java,"rumah").build()
            homeLD.postValue(db.rumahDao().selectAllRumahTermurah())

        }

        fun clearTask(rumah:Rumah){
            val db= Room.databaseBuilder(getApplication(), RumahDatabase::class.java,"rumah").build()
            db.rumahDao().deleteRumah(rumah)
            homeLD.postValue(db.rumahDao().selectAllRumah())
        }
    }

}