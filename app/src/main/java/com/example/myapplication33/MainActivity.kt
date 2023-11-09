package com.example.myapplication33

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private val correctEmail = "shandy123"
    private val correctPassword = "password123"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonClick = findViewById<Button>(R.id.masuk)
        val emailEditText = findViewById<EditText>(R.id.email)
        val passwordEditText = findViewById<EditText>(R.id.password)

        buttonClick.setOnClickListener {
            val enteredEmail = emailEditText.text.toString()
            val enteredPassword = passwordEditText.text.toString()

            if (enteredEmail == correctEmail && enteredPassword == correctPassword) {
                val intent = Intent(this, Navigasi::class.java)
                startActivity(intent)


            } else {
                Toast.makeText(this, "Email atau password salah. Coba lagi.", Toast.LENGTH_SHORT).show()
            }
        }

        val buttonClick2 = findViewById<Button>(R.id.daftar)
        buttonClick2.setOnClickListener {
            val intent = Intent(this, sign_up::class.java)
            startActivity(intent)
        }
    }
}
