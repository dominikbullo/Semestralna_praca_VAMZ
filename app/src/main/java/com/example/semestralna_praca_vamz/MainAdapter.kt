package com.example.semestralna_praca_vamz

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row.view.*

class MainAdapter : RecyclerView.Adapter<CustomViewHolder>() {

    val videoTitles = listOf("firts", "sec", "third")

    override fun getItemCount(): Int {
        return 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.itemView.textView_video_title.text = videoTitles.get(position)

    }

}

class CustomViewHolder(v: View) : RecyclerView.ViewHolder(v) {

}