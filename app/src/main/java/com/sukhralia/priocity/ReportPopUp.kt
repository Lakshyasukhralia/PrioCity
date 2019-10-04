package com.sukhralia.priocity

import android.graphics.Color
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.popup_report.*

class ReportPopUp :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.popup_report)

        val bgColor = intent.getStringExtra("bgColor")

        window.decorView.setBackgroundColor(Color.parseColor(bgColor))

        val displayMetric = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetric)

        val width = displayMetric.widthPixels
        val height = displayMetric.heightPixels

        window.setLayout((width * .8).toInt(),(height * .4).toInt())

        val issue = intent.getStringExtra("issue")
        textIssuePop.text = issue


    }
}