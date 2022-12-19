package com.antgut.rss_app.management.presentation

import android.content.Context
import android.content.SharedPreferences
import com.antgut.app.serializer.GsonSerializer
import com.antgut.app.serializer.KSerializer
import com.antgut.rss_app.management.data.RssDataRepository
import com.antgut.rss_app.management.data.local.datastore.DataStoreLocalDataSource
import com.antgut.rss_app.management.data.local.xml.XmlDataSource
import com.antgut.rss_app.management.domain.DeleteRssUseCase
import com.antgut.rss_app.management.domain.GetUserUseCase

class ManagerFactory {
    fun getRss(
        serializer: KSerializer,
        sharedPreferences: SharedPreferences,
        applicationContext: Context
    ): ManagerViewModel {
        return ManagerViewModel(
            GetUserUseCase(
                RssDataRepository(
                    DataStoreLocalDataSource(
                        applicationContext, GsonSerializer()
                    )
                )
            ),
            DeleteRssUseCase(
                RssDataRepository(
                    DataStoreLocalDataSource(
                        applicationContext, GsonSerializer()
                    )
                )
            )
        )
    }
}