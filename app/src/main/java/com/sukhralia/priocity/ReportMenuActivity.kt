package com.sukhralia.priocity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.menu_report.*

class ReportMenuActivity : AppCompatActivity(){

    lateinit var reportList:MutableList<IssueDTO>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_report)

        reportList = mutableListOf()

        btnSubmitReport.setOnClickListener {
            val intent = Intent(this,ReportSubmissionActivity::class.java)
            startActivity(intent)
        }

        btnAllReports.setOnClickListener {

            val ref = FirebaseDatabase.getInstance().getReference("IssueRequestNode")
            ref.addValueEventListener(object:ValueEventListener{
                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onDataChange(p0: DataSnapshot) {
                    if(p0!!.exists()){
                        reportList.clear()
                        for(r in p0.children){
                            val report = r.getValue(IssueDTO::class.java)
                            reportList.add(report!!)
                        }
                    }

                    val intent = Intent(this@ReportMenuActivity,ReportAllActivity::class.java)
                    intent.putParcelableArrayListExtra("reportList",ArrayList(reportList))
                    startActivity(intent)
                    Log.i("reportList",reportList.toString())
                }

            })
        }
    }
}