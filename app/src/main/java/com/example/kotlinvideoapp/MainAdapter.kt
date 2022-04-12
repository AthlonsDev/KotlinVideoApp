package com.example.kotlinvideoapp

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

class MainAdapter: RecyclerView.Adapter<CustomViewHolder>() {

//    number of items
    override fun getItemCount(): Int {
        return 3
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ??? {

    }

    override fun onBindViewHolder(p0: ???, p1: Int) {
        TODO("Not yet implemented")
    }
}

class CustomViewHolder(v: View): RecyclerView.ViewHolder(v) {

}