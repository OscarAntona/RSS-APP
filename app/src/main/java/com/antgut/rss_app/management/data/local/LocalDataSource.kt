package com.antgut.rss_app.management.data.local

interface LocalDataSource {
    suspend fun createRss(url: String, name: String)
}