package com.anmp.projekuts.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Users(
    @ColumnInfo(name="nama")
    val nama:String?,
    @ColumnInfo(name="email")
    val email:String?,
    @ColumnInfo(name="nohp")
    val nohp:String?,
    @ColumnInfo(name="username")
    val username:String?,
    @ColumnInfo(name="password")
    val password:String?
){
    @PrimaryKey(autoGenerate = true)
    var iduser:Int=0
}