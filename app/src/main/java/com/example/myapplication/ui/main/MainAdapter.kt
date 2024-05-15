package com.example.myapplication.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MainAdapter (private val dataSet: List<Pair<Int, Int>>) : RecyclerView.Adapter<MainAdapter.ViewHolder>()  {

    private val patterns = listOf(
        listOf("circle", "square", "square", "cross", "circle"),
        listOf("cross", "cross", "square", "circle")
    )

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvIndex: TextView = view.findViewById(R.id.tvIndex)
        val tvNumber: TextView = view.findViewById(R.id.tvNumber)
        val imageShape: ImageView = view.findViewById(R.id.imageShape)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val (index, number) = dataSet[position]
        val cycleIndex = (position / patterns[0].size) % patterns.size
        val cyclePosition = position % patterns[cycleIndex].size
        val itemType = patterns[cycleIndex][cyclePosition]

        holder.imageShape.visibility = View.GONE
        holder.imageShape.visibility = View.GONE

        when (itemType) {
            "circle" -> {
                holder.imageShape.setImageResource(R.drawable.ic_checked)
                holder.imageShape.visibility = View.VISIBLE
            }
            "square" -> {
                holder.imageShape.setImageResource(R.drawable.ic_square)
                holder.imageShape.visibility = View.VISIBLE
            }
            "cross" -> {
                holder.imageShape.setImageResource(R.drawable.ic_cross)
                holder.imageShape.visibility = View.VISIBLE
            }
            "cross2" -> {
                holder.imageShape.setImageResource(R.drawable.ic_cross)
                holder.imageShape.visibility = View.VISIBLE
            }
        }
    }

    override fun getItemCount() = dataSet.size

}