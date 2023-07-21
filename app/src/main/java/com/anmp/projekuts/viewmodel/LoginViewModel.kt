package com.anmp.projekuts.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.anmp.projekuts.model.Rumah
import com.anmp.projekuts.model.RumahDatabase
import com.anmp.projekuts.model.Users
import com.anmp.projekuts.model.UsersDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class LoginViewModel (application: Application): AndroidViewModel(application), CoroutineScope {
    val homeLD=MutableLiveData<Users>()
    private var job= Job()

    override val coroutineContext: CoroutineContext
        get() = job+ Dispatchers.IO

    fun login(username:String,password:String){
        launch {
            val db= Room.databaseBuilder(getApplication(), UsersDatabase::class.java,"users").build()
            homeLD.postValue(db.usersDao().login(username,password))

        }
    }

}