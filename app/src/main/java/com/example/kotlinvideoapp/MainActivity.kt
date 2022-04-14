package com.example.kotlinvideoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.google.gson.GsonBuilder
import com.google.gson.internal.GsonBuildConfig
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recView_main = findViewById<RecyclerView>(R.id.recyclerView_main)

        recView_main.layoutManager = LinearLayoutManager(this)
//        recView_main.adapter = MainAdapter()

        fetchJson()


    }


    fun fetchJson() {
        println("Attempitng to fetch json")

        val url = "https://api.letsbuildthatapp.com/youtube/home_feed"

        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()
        client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call, response: Response) {
                val body = response.body()?.string()
                println(body)

                val gson = GsonBuilder().create()
                val homeFeed = gson.fromJson(body, HomeFeedModel::class.java)

                val recView_main = findViewById<RecyclerView>(R.id.recyclerView_main)


                runOnUiThread {
                    recView_main.adapter = MainAdapter(homeFeed)
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute response")
            }
        })
    }



}


