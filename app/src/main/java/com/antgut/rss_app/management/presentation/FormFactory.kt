package com.antgut.rss_app.management.presentation

import android.content.Context
import android.content.SharedPreferences
import com.antgut.app.serializer.GsonSerializer
import com.antgut.app.serializer.KSerializer
import com.antgut.rss_app.management.data.RssDataRepository
import com.antgut.rss_app.management.data.local.datastore.DataStoreLocalDataSource
import com.antgut.rss_app.management.data.local.xml.XmlDataSource
import com.antgut.rss_app.management.domain.AddRssUseCase

class FormFactory {
    fun saveUserRss(sharedPreferences: SharedPreferences, serializer: KSerializer,applicationContext: Context):FormViewModel{
        return FormViewModel(
            AddRssUseCase(
                RssDataRepository(
                    DataStoreLocalDataSource(
                        applicationContext, GsonSerializer()
                    )
                )
            )
        )
    }
}