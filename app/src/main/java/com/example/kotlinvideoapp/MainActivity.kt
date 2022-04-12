package com.example.kotlinvideoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recView_main = findViewById<RecyclerView>(R.id.recyclerView_main)

        recView_main.layoutManager = LinearLayoutManager(this)
        recView_main.adapter = MainAdapter()
    }
}