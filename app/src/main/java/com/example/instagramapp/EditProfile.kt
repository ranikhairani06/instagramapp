package com.example.instagramapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class EditProfile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_edit_profile)

        val etName = findViewById<EditText>(R.id.etName)
        val etBio = findViewById<EditText>(R.id.etBio)
        val btnSave = findViewById<Button>(R.id.btnSave)

        // Menampilkan data nama dan bio dari MainActivity
        etName.setText(intent.getStringExtra(MainActivity.EXTRA_NAME))
        etBio.setText(intent.getStringExtra(MainActivity.EXTRA_BIO))

        btnSave.setOnClickListener {

            val resultIntent = Intent()

            // Memasukkan data yang sudah diedit ke Intent
            resultIntent.putExtra(
                MainActivity.EXTRA_NAME,
                etName.text.toString()
            )

            resultIntent.putExtra(
                MainActivity.EXTRA_BIO,
                etBio.text.toString()
            )

            // Mengirim hasil kembali ke MainActivity
            setResult(Activity.RESULT_OK, resultIntent)

            // Menutup EditProfile
            finish()
        }
    }
}