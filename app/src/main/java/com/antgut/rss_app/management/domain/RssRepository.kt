package com.antgut.rss_app.management.domain

interface RssRepository {
    suspend fun saveRssUser(url: String, name: String)
    suspend fun getRssUser():List<ManagementModel>

}