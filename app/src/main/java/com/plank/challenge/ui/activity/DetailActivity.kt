package com.plank.challenge.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.plank.challenge.R
import com.plank.challenge.database.AppPreferences

class DetailActivity : AppCompatActivity() {

    private lateinit var appPreferences: AppPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        appPreferences = AppPreferences(this)

        if (appPreferences.getLevel() != 0) {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

    }
}