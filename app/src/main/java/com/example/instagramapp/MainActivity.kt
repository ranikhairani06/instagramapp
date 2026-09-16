package com.example.instagramapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.instagramapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val launcher =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->

            if (result.resultCode == Activity.RESULT_OK) {

                val data = result.data

                val name = data?.getStringExtra(EXTRA_NAME)
                val bio = data?.getStringExtra(EXTRA_BIO)

                binding.tvName.text = name
                binding.tvBio.text = bio
            }
        }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_BIO = "extra_bio"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEdit.setOnClickListener {

            val intent = Intent(
                this@MainActivity,
                EditProfile::class.java
            )

            intent.putExtra(
                EXTRA_NAME,
                binding.tvName.text.toString()
            )

            intent.putExtra(
                EXTRA_BIO,
                binding.tvBio.text.toString()
            )

            launcher.launch(intent)
        }
    }
}