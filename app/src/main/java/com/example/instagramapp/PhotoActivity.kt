package com.example.instagramapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PhotoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_photo)

        val tvPhotoName = findViewById<TextView>(R.id.tvPhotoName)
        val btnBack = findViewById<Button>(R.id.btnBack)

        val name = intent.getStringExtra(MainActivity.EXTRA_NAME)

        tvPhotoName.text = name

        btnBack.setOnClickListener {
            finish()
        }
    }
}