package com.example.kotlinvideoapp

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.detail_activity.*

class DetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)
        recycler_detail.layoutManager = LinearLayoutManager(this)
        recycler_detail.adapter = DetailAdapter()
//        recycler_detail.setBackgroundColor(Color.BLUE)
    }

    private class DetailAdapter: RecyclerView.Adapter<DetailViewHolder>() {

        override fun getItemCount(): Int {
            return 5
        }

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DetailViewHolder {

            val layoutInflater = LayoutInflater.from(p0.context)
            val customView = layoutInflater.inflate(R.layout.detail_row, p0, false)


//            val redView = View(p0.context)
//            redView.setBackgroundColor(Color.RED)
//            redView.minimumHeight = 100
            return DetailViewHolder(customView)

        }

        override fun onBindViewHolder(holder: DetailViewHolder, index: Int) {



        }

    }



    class DetailViewHolder(val customView: View): RecyclerView.ViewHolder (customView){



    }
}