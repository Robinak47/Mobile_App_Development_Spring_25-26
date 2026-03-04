package com.example.gridviewcustomadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class StudentAdapter(var context: Context, var studentNames: ArrayList<String>, var studentIds: ArrayList<String>): BaseAdapter() {




    override fun getCount(): Int {
        return studentNames.size;
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        val view:View= LayoutInflater.from(context).inflate(R.layout.custom_design,parent,false)

        var stdNameTxt=view.findViewById<TextView>(R.id.stdName)

        var stdIdTxt=view.findViewById<TextView>(R.id.stdId)

        stdIdTxt.setText(studentIds[position])
        stdNameTxt.setText(studentNames[position])
        return view
    

    }
}