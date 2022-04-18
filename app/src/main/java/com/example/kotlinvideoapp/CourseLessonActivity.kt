package com.example.kotlinvideoapp

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.weblayout.*

class CourseLessonActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.weblayout)
//        web_course_lesson.setBackgroundColor(Color.YELLOW)
        val courseLink = intent.getStringExtra(DetailActivity.DetailViewHolder.COURSE_LESSON_KEY)

        web_course_lesson.settings.javaScriptEnabled = true
        web_course_lesson.settings.loadWithOverviewMode = true
        web_course_lesson.settings.useWideViewPort = true


        web_course_lesson.loadUrl(courseLink.toString())

        println(" Course Link: " + courseLink)
    }
}