package com.example.kotlinvideoapp

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.videorow.view.*

class MainAdapter(val homeFeed: HomeFeedModel): RecyclerView.Adapter<CustomViewHolder>() {

    val videoTitles = listOf<String>("First Video", "Second Video", "Third Video", "Fourth Video")

//    number of items
    override fun getItemCount(): Int {
        return homeFeed.videos.count()
    }

    override fun onCreateViewHolder(view: ViewGroup, index: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(view?.context)
        val cellForRow = layoutInflater.inflate(R.layout.videorow, view, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, index: Int) {
//        val videoTitle = videoTitles.get(index)
        val videos = homeFeed.videos.get(index)
        holder.view.findViewById<TextView>(R.id.textView_videoTitle).text = videos.name

        holder.view.textView_channel.text = videos.channel.name + " . " + "20k Views \n 4 days ago"

        val thumbnail = holder.view.findViewById<ImageView>(R.id.imageView_thumbnail)
        Picasso.get().load(videos.imageUrl).into(thumbnail);

        val channelProfileImageView = holder.view.findViewById<ImageView>(R.id.imageView_profile)
        Picasso.get().load(videos.channel.profileimageUrl).into(channelProfileImageView);

        holder.video = videos
    }
}

class CustomViewHolder(val view: View, var video: Video? = null): RecyclerView.ViewHolder(view) {

    companion object {
        val VIDEO_TITLE_KEY = "VIDEO_TITLE"
        val VIDEO_ID_KEY = "VIDEOS_ID"
    }

    init {
        view.setOnClickListener {
//            Configure new activity
            val intent = Intent(view.context, DetailActivity::class.java)
            intent.putExtra(VIDEO_TITLE_KEY, video?.name)
            intent.putExtra(VIDEO_ID_KEY, video?.id)
//            Start new Activity
            view.context.startActivity(intent)
        }
    }

}