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
import com.anmp.projekuts.model.Users
import com.anmp.projekuts.model.UsersDatabase
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

//class ViewModelList (application: Application): AndroidViewModel(application) {
//    val homeLD = MutableLiveData<ArrayList<Rumah>>()
//    val TAG="allTag"
//    private var queue: RequestQueue? = null
//
//    fun refresh() {
//        queue = Volley.newRequestQueue(getApplication())
//        val url = "http://192.168.100.43/projekanmp/listKos.php"
//        val stringRequest = StringRequest(
//            Request.Method.GET, url,
//            {
//                val sType = object : TypeToken<List<Rumah>>() { }.type
//                val result = Gson().fromJson<List<Rumah>>(it, sType)
//                homeLD.value = result as ArrayList<Rumah>?
//                Log.d("showvoley", result.toString())
//            },
//            {
//                Log.d("showvoley", it.toString())
//            })
//        stringRequest.tag   = TAG
//        queue?.add(stringRequest)
//
//    }
//    override fun onCleared() {
//        super.onCleared()
//        queue?.cancelAll(TAG)
//    }
//
//}
class ViewModelList (application: Application): AndroidViewModel(application),CoroutineScope {
    val homeLD=MutableLiveData<List<Rumah>>()
    private var job= Job()

    override val coroutineContext: CoroutineContext
        get() = job+Dispatchers.IO
    fun add(list:List<Rumah>){
        launch {
            val db= Room.databaseBuilder(getApplication(), RumahDatabase::class.java,"rumah").build()
            db.rumahDao().insertAll(*list.toTypedArray())
        }
    }
    fun refresh(){
        launch {
            val db=Room.databaseBuilder(getApplication(),RumahDatabase::class.java,"rumah").build()
            homeLD.postValue(db.rumahDao().selectAllRumah())
        }
    }

    fun clearTask(rumah:Rumah){
        val db=Room.databaseBuilder(getApplication(),RumahDatabase::class.java,"rumah").build()
        db.rumahDao().deleteRumah(rumah)
        homeLD.postValue(db.rumahDao().selectAllRumah())
    }
}