package com.antgut.rss_app.management.domain

import kotlinx.coroutines.flow.Flow

interface RssRepository {
    suspend fun saveRssUser(url: String, name: String)
    fun getRssUser(): Flow<List<ManagementModel>>
    suspend fun deleteRss(url: String)
}