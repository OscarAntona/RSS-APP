package com.antgut.rss_app.management.domain

class Models {
    data class RssNews(val channel:String, val title:String, val description:String, val link:String, val pubDate:String, val creator:String, val content:String, val thumbnail:String)
}