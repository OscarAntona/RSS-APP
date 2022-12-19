package com.antgut.rss_app.management.data

import com.antgut.rss_app.management.data.local.datastore.DataStoreLocalDataSource
import com.antgut.rss_app.management.data.local.xml.XmlDataSource
import com.antgut.rss_app.management.domain.ManagementModel
import com.antgut.rss_app.management.domain.RssRepository
import kotlinx.coroutines.flow.Flow

class RssDataRepository (private val source: DataStoreLocalDataSource): RssRepository {

    override suspend fun saveRssUser(url: String, name: String) {
        source.saveUserRss(url,name)
    }

    override  fun getRssUser(): Flow<List<ManagementModel>> {
        return source.obtainUserRss()
    }
    override suspend fun deleteRss(url: String) {
        source.deleteUserRss(url)
    }

}