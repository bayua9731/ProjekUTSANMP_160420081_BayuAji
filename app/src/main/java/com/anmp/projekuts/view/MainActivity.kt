package com.anmp.projekuts.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.anmp.projekuts.R
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    var sharedFile="login"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var shared: SharedPreferences = getSharedPreferences(sharedFile,
            Context.MODE_PRIVATE )
        var editor:SharedPreferences.Editor = shared.edit()
        val x=intent.getIntExtra("idakun",0)
        editor.putInt("akun",x)
        editor.apply()
        var exist = shared.getInt("akun",0)
        Log.d("IDAKUNNNN",exist.toString())
            if(exist==0) {
                val intent = Intent(this, LogRegActivity::class.java)
                startActivity(intent)
            }

        drawerLayout = findViewById(R.id.drawerLayout)

        navController=(supportFragmentManager.findFragmentById(R.id.hostFragment) as NavHostFragment).navController


        NavigationUI.setupActionBarWithNavController(this, navController,drawerLayout)
        val navView = findViewById<NavigationView>(R.id.navView)
        NavigationUI.setupWithNavController(navView, navController)
        bottomNav.setupWithNavController(navController)

    }
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, drawerLayout)
                || super.onSupportNavigateUp()
    }
}