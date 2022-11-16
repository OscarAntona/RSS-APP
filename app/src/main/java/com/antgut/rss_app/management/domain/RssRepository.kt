package com.antgut.rss_app.management.domain

interface RssRepository {
    fun saveRss(rssModel: ManagementModel)
}