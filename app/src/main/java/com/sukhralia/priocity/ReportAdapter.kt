package com.sukhralia.priocity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_report_submit.view.*
import kotlinx.android.synthetic.main.report_item.view.*


class ReportAdapter(val context: Context,val reportList:MutableList<IssueDTO> ):RecyclerView.Adapter<ReportAdapter.ReportViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.report_item,parent,false)
        return ReportViewHolder(view)
    }

    override fun getItemCount(): Int {
        return reportList.size
    }

    override fun onBindViewHolder(holder: ReportViewHolder, position: Int) {
        val report = reportList[position]
        holder.setData(report)
    }

    inner class ReportViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun setData(report:IssueDTO?){

            var bgColor : String

            itemView.textRegion.text = report!!.region
            itemView.textCreateDate.text = report!!.createDate
            itemView.ratingPriorityCard.rating = report!!.priority
            itemView.textSubject.text = report!!.subject
            when(report.priority) {
                in 3.5f..5f -> bgColor = "#F08080"
                in 2f..3.5f -> bgColor = "#FFFFE0"
                else -> bgColor = "#98FB98"
            }

            itemView.cardView.setCardBackgroundColor(Color.parseColor(bgColor))

            itemView.cardView.setOnClickListener {
                val intent = Intent(it.context,ReportPopUp::class.java)
                intent.putExtra("issue",report.issue)
                intent.putExtra("bgColor",bgColor)
                it.context.startActivity(intent)
            }
        }
    }
}