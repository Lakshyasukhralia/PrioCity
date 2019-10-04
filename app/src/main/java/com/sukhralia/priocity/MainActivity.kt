package com.sukhralia.priocity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnReport.setOnClickListener {
            val intent = Intent(this,ReportMenuActivity::class.java)
            startActivity(intent)
        }
    }

}
