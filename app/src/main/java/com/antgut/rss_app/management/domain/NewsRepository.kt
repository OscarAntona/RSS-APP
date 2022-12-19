package com.antgut.rss_app.management.domain

interface NewsRssRepository {
    fun getNews(url:String): List<Models.RssNews>
}