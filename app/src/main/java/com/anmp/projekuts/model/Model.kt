package com.anmp.projekuts.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Rumah(
    @ColumnInfo(name="namaRumah")
    val namaRumah:String?,
    @ColumnInfo(name="alamat")
    val alamatRumah:String?,
    @ColumnInfo(name="harga")
    val hargaRumah:String?,
    @ColumnInfo(name="photo")
    val photo:String?,
    @ColumnInfo(name="jarak")
    val jarak:String?,
    @ColumnInfo(name="pemilik")
    val pemilikRumah:String?,
    @ColumnInfo(name="kontak")
    val nomorTelepon:String?,
    @ColumnInfo(name="deskripsi")
    val deskripsi:String?,
    @ColumnInfo(name="kategori")
    val kategori:String?
){
    @PrimaryKey(autoGenerate = true)
    var idRumah:Int=0
}