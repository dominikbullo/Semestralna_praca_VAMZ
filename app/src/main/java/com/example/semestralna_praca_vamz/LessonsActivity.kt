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
        webview_lesson.loadUrl("https://www.google.sk/")
    }
}