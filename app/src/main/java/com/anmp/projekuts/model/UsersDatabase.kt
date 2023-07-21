package com.anmp.projekuts.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Users::class), version = 1)
abstract class UsersDatabase: RoomDatabase() {
    abstract fun usersDao(): UsersDao

    companion object {
        @Volatile private var instance:UsersDatabase?=null
        private val LOCK=Any()

        private fun buildDatabase(context: Context)=
            Room.databaseBuilder(context.applicationContext,
                UsersDatabase::class.java,"users").build()
        operator fun invoke(context: Context){
            if(instance!=null){
                synchronized(LOCK){
                    instance?: buildDatabase(context).also {
                        instance=it
                    }
                }
            }
        }
    }
}
