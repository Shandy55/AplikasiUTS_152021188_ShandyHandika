package com.example.myapplication33

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class calcu : AppCompatActivity() {
    private var pilihan = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcu)
        val gEdt1 = findViewById<EditText>(R.id.edt_bil1)
        val gEdt2 = findViewById<EditText>(R.id.edt_bil2)
        val gSpin = findViewById<Spinner>(R.id.myspinner)
        val gBtnCal = findViewById<Button>(R.id.btn_calculate)
        val gTvHasil = findViewById<TextView>(R.id.tv_hasil)

        // Definisi Button Click
        gBtnCal.setOnClickListener {
            val nilai1 = gEdt1.text.toString().toDouble()
            val nilai2 = gEdt2.text.toString().toDouble()
            var hasil = 0.0

            Log.d("shan", "nilai1: $nilai1, nilai2: $nilai2")

            when (pilihan) {
                0 -> hasil = nilai1 + nilai2
                1 -> hasil = nilai1 - nilai2
                2 -> hasil = nilai1 * nilai2
                3 -> hasil = nilai1 / nilai2
            }

            gTvHasil.text = hasil.toString()
        }

        gSpin.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Log.d("Shandy", "pilih item: $p2")
                pilihan = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                // Tidak ada implementasi
            }
        })
    }

    fun goToHomeFragment(view: View) {
        finish() // Ini akan mengakhiri activity dan kembali ke halaman sebelumnya
    }
}