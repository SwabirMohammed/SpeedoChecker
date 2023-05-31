package com.example.speedochecker

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var welcomebutton:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        welcomebutton = findViewById(R.id.btnMainWelcome)



        welcomebutton.setOnClickListener {

            var setoff = Intent(this, LoginActivity::class.java)
            startActivity(setoff)
            finish()
        }



    }
}