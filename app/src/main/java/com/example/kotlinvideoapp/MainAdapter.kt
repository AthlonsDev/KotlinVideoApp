package com.example.kotlinvideoapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MainAdapter: RecyclerView.Adapter<CustomViewHolder>() {

    val videoTitles = listOf<String>("First Video", "Second Video", "Third Video", "Fourth Video")

//    number of items
    override fun getItemCount(): Int {
        return videoTitles.size
    }

    override fun onCreateViewHolder(view: ViewGroup, index: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(view?.context)
        val cellForRow = layoutInflater.inflate(R.layout.videorow, view, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, index: Int) {
        val videoTitle = videoTitles.get(index)
        holder.view.findViewById<TextView>(R.id.textView_videoTitle).text = videoTitle
    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

}