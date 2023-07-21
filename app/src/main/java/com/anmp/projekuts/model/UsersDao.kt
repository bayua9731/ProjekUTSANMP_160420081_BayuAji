package com.anmp.projekuts.model

import android.graphics.ColorSpace.Model
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UsersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg users:Users)

    @Query("SELECT * from users")
    fun selectUsers():List<Users>

    @Query("SELECT * FROM users where iduser=:id")
    fun selelctDetailUsers(id:Int):Users

    @Query("SELECT * FROM users where username=:username and password=:password")
    fun login(username:String,password:String):Users
    @Delete
    fun deleteRumah(users:Users)
}