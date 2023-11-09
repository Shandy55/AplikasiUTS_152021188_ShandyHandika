package com.example.myapplication33

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Navigasi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigasi)
        var bottomnav = findViewById<BottomNavigationView>(R.id.nav_menu)
        bottomnav.setOnItemSelectedListener{
            when(it.itemId) {
                R.id.Homefrag->{
                    loadFragment(FragmentHome())
                    true
                }
                R.id.chart->{
                    loadFragment(f_chart())
                    true
                }
                R.id.settings->{
                    loadFragment(f_settings())
                    true
                }
                else ->{false}
            }

        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            window.navigationBarColor = resources.getColor(R.color.private_acc)
//        }
    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.f_container,fragment)
        transaction.commit()
    }
}