package com.example.semestralna_praca_vamz

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lesson.*

class LessonsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_lesson)
//        webview_lesson.setBackgroundColor(Color.YELLOW)
        val link = intent.getStringExtra(DetailActivity.DetailLessonViewHolder.LESSON_LINK_KEY)

        webview_lesson.settings.javaScriptEnabled = true
        webview_lesson.settings.loadWithOverviewMode = true
        webview_lesson.settings.useWideViewPort = true

        webview_lesson.loadUrl(link)
    }
}