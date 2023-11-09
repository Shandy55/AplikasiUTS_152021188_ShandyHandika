package com.example.myapplication33

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class bmi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)
        val weightT = findViewById<EditText>(R.id.gwText)
        val heightT = findViewById<EditText>(R.id.ghText)
        val calBtn = findViewById<Button>(R.id.calBtn)


        calBtn.setOnClickListener {
            val weight= weightT.text.toString()
            val height = heightT.text.toString()
            if (validInput(weight,height))
            {
                val bmi= weight.toFloat()/((height.toFloat()/100)*(height.toFloat()/100))
                val bmi2D = String.format("%.2f",bmi).toFloat()
                displayResult(bmi2D)
            }
        }
    }


    private fun validInput(weight:String?,height:String?):Boolean{
        return when{
            weight.isNullOrEmpty() ->{
                Toast.makeText(this,"Weight is empty",Toast.LENGTH_SHORT).show()
                return false
            }
            height.isNullOrEmpty() ->{
                Toast.makeText(this,"Height is empty",Toast.LENGTH_SHORT).show()
                return false
            }

            else ->{
                return true
            }

        }
    }



    private fun displayResult(bmi:Float){
        val resultV= findViewById<TextView>(R.id.resultVidw)
        val resultDescV= findViewById<TextView>(R.id.resultDesView)
        val condViewV= findViewById<TextView>(R.id.resultVidwCondition)

        resultV.text=bmi.toString()
        condViewV.text= "(Normal range is 18.5 - 24.9)"

        var resultText= ""
        var color=0

        when{
            bmi<18.50 ->{
                resultText="Kurus"
                color= R.color.uw
            }
            bmi in 18.50..24.99 ->{
                resultText="Normal"
                color= R.color.oves
            }
            bmi in 25.00..29.99 ->{
                resultText="Gemuk"
                color= R.color.uw
            }

            bmi > 29.99 ->{
                resultText="Obesitas"
                color= R.color.over
            }
        }
        resultDescV.setTextColor(ContextCompat.getColor(this,color))
        resultDescV.text= resultText;

    }
    fun goToHomeFragment(view: View) {
        finish() // Ini akan mengakhiri activity dan kembali ke halaman sebelumnya
    }
}