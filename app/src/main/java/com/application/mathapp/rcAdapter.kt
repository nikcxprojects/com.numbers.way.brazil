package com.application.mathapp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class rcAdapter :RecyclerView.Adapter<rcAdapter.ViewHolder>() {
    val plantList = ArrayList<Data>()
    lateinit var context: Context

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val context = view.context
        lateinit var number:TextView

        fun bind(listItem:Data, context: Context) {
            number = itemView.findViewById(R.id.textView20)
            if(listItem.type == "math"){
                number.setTextColor(context.resources.getColor(R.color.MATH_color))
            }else if(listItem.type == ""){
                number.setTextColor(context.resources.getColor(R.color.TRIVIA_color))
            }else if(listItem.type == "data"){
                number.setTextColor(context.resources.getColor(R.color.DATE_color))
            }
            number.text = listItem.number
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rc_card, parent, false)
        context = parent.context
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(plantList[position],context)
    }

    override fun getItemCount(): Int {
        Log.d("sadasd",plantList.size.toString())
        return plantList.size
    }

    fun addPlant(plant: Data){
        plantList.add(plant)
    }

}