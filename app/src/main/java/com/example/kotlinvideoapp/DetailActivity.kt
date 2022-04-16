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
import com.google.gson.GsonBuilder
import com.google.gson.internal.GsonBuildConfig
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.detail_activity.*
import okhttp3.*
import java.io.IOException

class DetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)
        recycler_detail.layoutManager = LinearLayoutManager(this)
        recycler_detail.adapter = DetailAdapter()
//        recycler_detail.setBackgroundColor(Color.BLUE)

//        cahnge navbar title
        val navbartitle = intent.getStringExtra(CustomViewHolder.VIDEO_TITLE_KEY)
        supportActionBar?.title = navbartitle



        fetchJson()
    }

    private fun fetchJson() {
        val videoId = intent.getIntExtra(CustomViewHolder.VIDEO_ID_KEY, -1)

        val detailURL = "https://api.letsbuildthatapp.com/youtube/course_detail?id=" + videoId
        val client = OkHttpClient()
        val request = Request.Builder().url(detailURL).build()
        client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call, response: Response) {
                val body = response.body()?.string()
                val gSon = GsonBuilder().create()
                val courseLesssons = gSon.fromJson(body, Array<CourseLesson>::class.java)
            }

            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }
        })
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