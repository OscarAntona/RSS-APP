package com.antgut.rss_app.management.data

import com.antgut.rss_app.management.data.local.xml.XmlDataSource
import com.antgut.rss_app.management.domain.ManagementModel
import com.antgut.rss_app.management.domain.RssRepository

class RssDataRepository (private val source: XmlDataSource): RssRepository {

    override suspend fun saveRssUser(url: String, name: String) {
        source.createRss(url,name)
    }

    override suspend fun getRssUser(): List<ManagementModel> {
        return source.getRssUser()
    }

}