package com.antgut.rss_app.management.domain

interface RssRepository {
    suspend fun saveRss(url: String, name: String)
    suspend fun getRss():List<ManagementModel>

}