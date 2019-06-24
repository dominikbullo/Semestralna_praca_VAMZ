package com.example.semestralna_praca_vamz

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

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

//        recyclerView_main.setBackgroundColor(Color.RED)
        recyclerView_main.layoutManager = LinearLayoutManager(this)
        recyclerView_main.adapter = DetailAdapter()
    }

    private class DetailAdapter : RecyclerView.Adapter<DetailLessonViewHolder>() {

        override fun getItemCount(): Int {
            return 5
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailLessonViewHolder {

            var layoutInflater = LayoutInflater.from(parent.context)
            var customView = layoutInflater.inflate(R.layout.course_lesson_row, parent, false)

//            val blueView = View(parent.context)
//            blueView.setBackgroundColor(Color.BLUE)
//            blueView.minimumHeight = 50
            return DetailLessonViewHolder(customView)

        }

        override fun onBindViewHolder(p0: DetailLessonViewHolder, p1: Int) {

        }
    }

    private class DetailLessonViewHolder(val customView: View) : RecyclerView.ViewHolder(customView) {
    }

}