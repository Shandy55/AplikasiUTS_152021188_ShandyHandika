package com.example.myapplication33

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class sign_up : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val buttonClick = findViewById<Button>(R.id.back_button)
        buttonClick.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val buttonmasuk = findViewById<Button>(R.id.sign)
        buttonmasuk.setOnClickListener {
            val intent = Intent(this, Navigasi::class.java)
            startActivity(intent)
        }
    }
}