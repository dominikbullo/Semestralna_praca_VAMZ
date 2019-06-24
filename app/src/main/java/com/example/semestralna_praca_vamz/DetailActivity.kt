package com.example.semestralna_praca_vamz

import android.content.Intent
import android.content.res.Resources
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
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.course_lesson_row.view.*
import kotlinx.android.synthetic.main.row.view.*
import okhttp3.*
import java.io.IOException

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

//        recyclerView_main.setBackgroundColor(Color.RED)
        recyclerView_main.layoutManager = LinearLayoutManager(this)
//        recyclerView_main.adapter = DetailAdapter()

//        change navbar title
        var navBarTitle = intent.getStringExtra(CustomViewHolder.VIDEO_TITLE_KEY)
        supportActionBar?.title = navBarTitle

//        println(detailUrl)

        fetchJSON()
    }

    private fun fetchJSON() {
        var videoID = intent.getIntExtra(CustomViewHolder.VIDEO_ID_KEY, -1)
        val url = "https://api.fallbo.sk/VAMZ/detail_" + videoID + ".json"

        var request = Request.Builder().url(url).build()
        var client = OkHttpClient()

        // nemôžem volať priamo na main vlákne tak volám callbackovú funkciu na backgrounde
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
//                println(body)
                val gson = GsonBuilder().create()
                var lessons = gson.fromJson(body, Array<Lessons>::class.java)


                // musí bežať na main thred
                runOnUiThread() {
                    recyclerView_main.adapter = DetailAdapter(lessons)
                }

            }

            override fun onFailure(call: Call, e: IOException) {
                println("No response from server")
                println(e)
            }
        })

    }


    private class DetailAdapter(val lessons: Array<Lessons>) : RecyclerView.Adapter<DetailLessonViewHolder>() {

        override fun getItemCount(): Int {
            return lessons.count()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailLessonViewHolder {

            var layoutInflater = LayoutInflater.from(parent.context)
            var customView = layoutInflater.inflate(R.layout.course_lesson_row, parent, false)

//            val blueView = View(parent.context)
//            blueView.setBackgroundColor(Color.BLUE)
//            blueView.minimumHeight = 50
            return DetailLessonViewHolder(customView)

        }

        override fun onBindViewHolder(holder: DetailLessonViewHolder, position: Int) {

            val lesson = lessons.get(position)
            holder.customView.textView_lesson_title.text = lesson.name
            holder.customView.textView_duration.text = "Followers: " + lesson.duration.toString()

            val thumbnailImageView = holder.customView.imageView_lesson_thumbnail
            Picasso.with(holder.customView.context).load(lesson.imageUrl).into(thumbnailImageView)

            holder.lesson = lesson
        }
    }

    class DetailLessonViewHolder(val customView: View, var lesson: Lessons? = null) :
        RecyclerView.ViewHolder(customView) {
        companion object {
            val LESSON_LINK_KEY = "LESSON_LINK"
        }


        init {
            customView.setOnClickListener {
                //                println("TEST")

                var intent = Intent(customView.context, LessonsActivity::class.java)
                intent.putExtra(LESSON_LINK_KEY, lesson?.link)
                customView.context.startActivity(intent)

            }
        }
    }
}

