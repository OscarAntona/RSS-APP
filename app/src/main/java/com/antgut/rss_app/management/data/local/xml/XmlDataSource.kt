package com.antgut.rss_app.management.data.local.xml

import android.content.SharedPreferences
import com.antgut.app.serializer.KSerializer
import com.antgut.rss_app.management.data.local.LocalDataSource
import com.antgut.rss_app.management.domain.ManagementModel

class XmlDataSource(
    private val sharedPreferences: SharedPreferences,
    private val serializer: KSerializer
) : LocalDataSource {

    private val editor = sharedPreferences.edit()

    override suspend fun createRss(url: String, name: String) {
        editor.putString(url,name).apply()
    }
    override suspend fun getRss(): List<ManagementModel> {
        val listRss = mutableListOf<ManagementModel>()
        sharedPreferences.all.forEach {
            editor.apply {
                listRss.add(serializer.fromJson(it.value as String, ManagementModel::class.java))
            }.apply()
        }
        return listRss
    }


}