package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CatAdapter(var context: Context, var catNames:ArrayList<String>, var catImages:ArrayList<Int>):
    RecyclerView.Adapter<CatAdapter.catViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): catViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.card,parent,false)

        return catViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: catViewHolder,
        position: Int
    ) {
        holder.catNames.text=catNames.get(position)
        holder.catImages.setImageResource(catImages.get(position))

    }

    override fun getItemCount(): Int {
        return catNames.size
    }


    class catViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val catNames: TextView=itemView.findViewById(R.id.nameId)
        val catImages: ImageView=itemView.findViewById(R.id.imgid)




    }
}