package com.antgut.rss_app.management.data.local

import com.antgut.rss_app.management.domain.ManagementModel

interface LocalDataSource {
    suspend fun createRss(url: String, name: String)
    suspend fun getRss():List<ManagementModel>
}