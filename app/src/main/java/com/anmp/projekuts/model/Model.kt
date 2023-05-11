package com.anmp.projekuts.model

import com.google.gson.annotations.SerializedName

data class Rumah(
    val id:String?,
    @SerializedName("nama")
    val namaRumah:String?,
    @SerializedName("alamat")
    val alamatRumah:String?,
    @SerializedName("harga")
    val hargaRumah:String?,
    val photo:String?,
    val jarak:String?,
    @SerializedName("pemilik")
    val pemilikRumah:String?,
    @SerializedName("kontak")
    val nomorTelepon:String?,
    val deskripsi:String?,
    val kategori:String?

)