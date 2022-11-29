package com.antgut.rss_app.management.data

import com.antgut.rss_app.management.data.local.LocalDataSource
import com.antgut.rss_app.management.domain.RssRepository

class RssDataRepository (private val source: LocalDataSource): RssRepository {

    override suspend fun saveRss(url: String, name: String) {
        source.createRss(url,name)
    }

}