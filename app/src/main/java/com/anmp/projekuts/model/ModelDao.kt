package com.anmp.projekuts.model

import android.graphics.ColorSpace.Model
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RumahDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg rumah:Rumah)

    @Query("SELECT * from rumah")
    fun selectAllRumah():List<Rumah>

    @Query("SELECT * FROM rumah where idRumah=:id")
    fun selectDetailRumah(id:Int):Rumah

    @Query("SELECT * FROM rumah where idRumah=:id")
    fun selectRumah(id:Int):List<Rumah>


    @Delete
    fun deleteRumah(rumah:Rumah)

    @Query("SELECT * from rumah where kategori=:filter")
    fun selectAllRumahPutra(filter:String):List<Rumah>

    @Query("SELECT * from rumah where kategori=:filter")
    fun selectAllRumahPutri(filter:String):List<Rumah>

    @Query("SELECT * from rumah ORDER BY 'jarak' ASC")
    fun selectAllRumahTerdekat():List<Rumah>

    @Query("SELECT * from rumah ORDER BY 'harga' ASC")
    fun selectAllRumahTermurah():List<Rumah>

    @Query("SELECT * from rumah where namaRumah like :query")
    fun selectSearchRumah(query:String):List<Rumah>

}