package com.example.kotlinvideoapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.detail_activity.*
import kotlinx.android.synthetic.main.detail_row.view.*
import okhttp3.*
import java.io.IOException

class DetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)
        recycler_detail.layoutManager = LinearLayoutManager(this)

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
                runOnUiThread {
                    recycler_detail.adapter = DetailAdapter(detailFeed = courseLesssons)
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }
        })
    }

    private class DetailAdapter(detailFeed: Array<CourseLesson>): RecyclerView.Adapter<DetailViewHolder>() {

        val feed = detailFeed

        override fun getItemCount(): Int {
            return feed.count()
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

            val videos = feed.get(index)
            holder.customView.titleView.text = videos.name
            holder.customView.subTitleView.text = videos.duration + " mins"
            val thumbnail = holder.customView.imageView
            Picasso.get().load(videos.imageUrl).into(thumbnail)

            holder.obj = videos

            println(println("Link:  " + videos.link))

        }
    }



    class DetailViewHolder(val customView: View, var obj: CourseLesson? = null): RecyclerView.ViewHolder (customView){

        companion object {
            val COURSE_LESSON_KEY = "COURSE_LESSON_LINK"
        }

        init {
            customView.setOnClickListener {
                println("Load Webview")
                val intent = Intent(customView.context, CourseLessonActivity::class.java)

                println("Course Link:  " + obj?.link)

                intent.putExtra(COURSE_LESSON_KEY, obj?.link)

                customView.context.startActivity(intent)

            }
        }

    }
}