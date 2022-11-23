package com.antgut.rss_app.management.data.local.xml

import android.content.SharedPreferences
import com.antgut.rss_app.app.serializer.KSerializer
import com.antgut.rss_app.management.domain.ManagementModel
import com.antgut.rss_app.management.data.local.LocalDataSource

class XmlDataSource(
    private val sharedPreferences: SharedPreferences,
    private val serializer: KSerializer
) :
    LocalDataSource {

    private val editor = sharedPreferences.edit()

    override suspend fun createRss(url: String, name: String) {
        editor.putString(url,name).apply()
    }


}