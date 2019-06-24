package com.example.semestralna_praca_vamz

class HomeFeed(val videos: List<Video>)

class Video(
    val id: Int, val name: String, val link: String, val imageUrl: String, val numberOFViews: Int, val channel: Channel
)

class Channel(val name: String, val profileImageUrl: String)

class Lessons(val name: String, val duration: String, val number: Int, val imageUrl: String, val link: String)