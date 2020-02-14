package com.example.notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notification.ui.NotificationsFragment
import com.example.notification.R

class NotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, NotificationsFragment())
                .commitNow()
        }
    }

}
