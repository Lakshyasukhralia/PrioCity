package com.sukhralia.priocity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_report.*

class ReportAllActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        val bundle : Bundle? = intent.extras
        val reportList = bundle!!.getParcelableArrayList<IssueDTO>("reportList")

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerReportView.layoutManager = layoutManager

        val adapter = ReportAdapter(this,reportList)
        recyclerReportView.adapter = adapter
    }
}