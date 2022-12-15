package com.antgut.rss_app.management.presentation

import android.content.SharedPreferences
import com.antgut.app.serializer.KSerializer
import com.antgut.rss_app.management.data.RssDataRepository
import com.antgut.rss_app.management.data.local.xml.XmlDataSource
import com.antgut.rss_app.management.domain.AddRssUseCase

class FormFactory {
    fun saveUserRss(sharedPreferences: SharedPreferences, serializer: KSerializer):FormViewModel{
        return FormViewModel(
            AddRssUseCase(
                RssDataRepository(
                    XmlDataSource(
                        sharedPreferences, serializer
                    )
                )
            )
        )
    }
}