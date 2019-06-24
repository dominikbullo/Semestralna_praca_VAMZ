package com.example.semestralna_praca_vamz

import android.content.Intent
import android.provider.Settings.Global.getString
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row.view.*

class MainAdapter(val homeFeed: HomeFeed) : RecyclerView.Adapter<CustomViewHolder>() {

//    val videoTitles = listOf("firts", "sec", "third")

    override fun getItemCount(): Int {
        return homeFeed.videos.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val video = homeFeed.videos.get(position)
        holder.itemView.textView_video_title.text = video.name
        holder.itemView.textView_channel_name.text = video.channel.name

        val thumbnailImageView = holder.itemView.imageView_thumbnail_video
        Picasso.with(holder.itemView.context).load(video.imageUrl).into(thumbnailImageView)

        val chanelProfileImageView = holder.itemView.imageView_chanel_profile
        Picasso.with(holder.itemView.context).load(video.channel.profileImageUrl).into(chanelProfileImageView)


        holder.video = video
    }

}

class CustomViewHolder(val view: View, var video: Video? = null) : RecyclerView.ViewHolder(view) {
    companion object {
        val VIDEO_TITLE_KEY = "VIDEO_TITLE"
        val VIDEO_ID_KEY = "VIDEO_ID"
    }

    init {
        view.setOnClickListener {
            println("TEST")

            var intent = Intent(view.context, DetailActivity::class.java)

            intent.putExtra(VIDEO_TITLE_KEY, video?.name)
            intent.putExtra(VIDEO_ID_KEY, video?.id)
            view.context.startActivity(intent)
        }
    }

}