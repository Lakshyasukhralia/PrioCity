package com.sukhralia.priocity

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_report_submit.*

class ReportSubmissionActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_submit)

        setRegion()

        btnSubmit.setOnClickListener {

            val region :String? = spinnerRegion.selectedItem.toString()
            val priority : Float? = ratingPriority.rating
            val subject : String? = editSubject.text.toString()
            val issue : String? = editIssue.text.toString()

            if (priority!=0f&&!issue.isNullOrBlank())
                saveToDB(region!!,priority!!,subject!!,issue)
            else
                Toast.makeText(this,"Missing fields : Failed to push!", Toast.LENGTH_SHORT).show()
        }
    }

    fun saveToDB(region:String, priority:Float, subject:String,issue:String){
        val ref = FirebaseDatabase.getInstance().getReference("IssueRequestNode")
        val pId = ref.push().key

        val reportObject = IssueRequest(pId!!,region,priority,subject,issue)
        ref.child(pId!!).setValue(reportObject).addOnCompleteListener {
        Toast.makeText(this,"Successfully pushed", Toast.LENGTH_SHORT).show()
        }
    }

    fun setRegion(){
        val region = arrayOf("Gurugram","Bhiwadi","Dharuhera","Rewari")
        val areaAdapter = ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,region)
        spinnerRegion.adapter = areaAdapter
    }
}