package com.example.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dashboard.ui.DashboardFragment

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, DashboardFragment())
                .commitNow()
        }
    }

}
