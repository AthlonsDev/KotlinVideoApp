package com.example.kotlinvideoapp

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.detail_activity.*

class DetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)
        recycler_detail.layoutManager = LinearLayoutManager(this)
        recycler_detail.adapter
        recycler_detail.setBackgroundColor(Color.BLUE)
    }

    private class DetailAdapter: RecyclerView.Adapter<DetailViewHolder>() {

        override fun getItemCount(): Int {
            return 5
        }

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DetailViewHolder {
            val redView = View(p0.context)
            redView.setBackgroundColor(Color.RED)
            redView.minimumHeight = 50
            return DetailViewHolder(redView)

        }

        override fun onBindViewHolder(p0: DetailViewHolder, p1: Int) {



        }

    }



    class DetailViewHolder(val customView: View): RecyclerView.ViewHolder (customView){



    }
}