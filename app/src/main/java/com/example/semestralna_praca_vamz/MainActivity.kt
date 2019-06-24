package com.example.semestralna_praca_vamz

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        recyclerView_main.setBackgroundColor(Color.BLUE)
        recyclerView_main.layoutManager = LinearLayoutManager(this)
//        recyclerView_main.adapter = MainAdapter()

        fetchJson()
    }

    fun fetchJson() {
        println("Attempting to fetch JSON")

        var url = "https://api.fallbo.sk/VAMZ/home_feed.json"

        var request = Request.Builder().url(url).build()

        var client = OkHttpClient()

        // nemôžem volať priamo na main vlákne tak volám callbackovú funkciu na backgrounde
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                println(body)

                val gson = GsonBuilder().create()

                var homefeed = gson.fromJson(body, HomeFeed::class.java)

                // musí bežať na main thred
                runOnUiThread() {
                    recyclerView_main.adapter = MainAdapter(homefeed)
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                println("No response from server")
                println(e)
            }
        })
    }
}