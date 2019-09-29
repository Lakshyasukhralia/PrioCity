package com.sukhralia.priocity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.report_item.view.*


class ReportAdapter(val context: Context,val reportList:List<IssueDTO> ):RecyclerView.Adapter<ReportAdapter.ReportViewHolder>() {
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
        itemView.textRegion.text = report!!.region
        }
    }
}