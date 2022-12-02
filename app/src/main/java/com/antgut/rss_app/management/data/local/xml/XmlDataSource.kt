package com.antgut.rss_app.management.data.local.xml

import android.content.SharedPreferences
import com.antgut.app.serializer.KSerializer
import com.antgut.rss_app.management.data.local.LocalDataSource
import com.antgut.rss_app.management.domain.ManagementModel

class XmlDataSource(val sharedPreferences: SharedPreferences, val serializer: KSerializer) : LocalDataSource {

    val editor = sharedPreferences.edit()

    override suspend fun createRss(url: String, name: String) {
        editor.putString(url, serializer.toJson(ManagementModel(url, name), ManagementModel::class.java))
        editor.apply()
    }
    override suspend fun getRssUser(): List<ManagementModel> {
        val rssList = mutableListOf<ManagementModel>()
        sharedPreferences.all.forEach {
            editor.apply {
                rssList.add(serializer.fromJson(it.value as String, ManagementModel::class.java))
            }.apply()
        }
        return rssList
    }


}