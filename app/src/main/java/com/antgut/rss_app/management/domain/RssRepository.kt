package com.antgut.rss_app.management.domain

interface RssRepository {
    suspend fun saveRss(rssModel: ManagementModel)
}