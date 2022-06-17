package com.example.tipppp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.tipppp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var b: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        val button: Button =b.calculateButton
        button.setOnClickListener(){
            calculate()
        }
    }
    @SuppressLint("SetTextI18n")
    fun calculate(){
        val a=b.costOfService.text
        val cost1:String=a.toString()
        val cost=cost1.toDouble()
        val select=b.tipOptions.checkedRadioButtonId
        val tippercent=when(select){
            R.id.option_twenty_percent->0.20
            R.id.option_eighteen_percent->0.18
            else -> 0.15
        }
        var tip=cost*tippercent
        val r=b.roundUpSwitch.isChecked
        if(r){
            tip = kotlin.math.ceil(tip)
        }
        val text: TextView =b.tipResult
        text.text="Tip Amount : $ ${tip.toString()}"
    }
}