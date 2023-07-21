package com.anmp.projekuts.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Rumah::class), version = 1)
abstract class RumahDatabase: RoomDatabase() {
    abstract fun rumahDao(): RumahDao

    companion object {
        @Volatile private var instance:RumahDatabase?=null
        private val LOCK=Any()

        private fun buildDatabase(context: Context)=
            Room.databaseBuilder(context.applicationContext,
                RumahDatabase::class.java,"rumah").build()
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
