package com.example.myapplication33

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Edit_profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

    }
    fun goToSettingsFragment(view: View) {
        finish() // Ini akan mengakhiri activity dan kembali ke halaman sebelumnya
    }
}