package com.example.basicarchitecture

import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //Launch Koin Container
        startKoin { androidContext(applicationContext) }

        val data: Uri? = intent?.data
        when {
            "/home" in data.toString() -> {
//                supportFragmentManager.beginTransaction().replace(R.id.content, HomeFragment).commit();
                Log.d("Hello", "Home URL")
            }
            "/dashboard" in data.toString() -> {
                Log.d("Hello", "Dashboard URL")
            }
            "/notifications" in data.toString() -> {
                Log.d("Hello", "Notifications URL")
            }
        }
    }
}
