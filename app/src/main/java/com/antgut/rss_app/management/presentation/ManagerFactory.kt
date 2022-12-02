package com.antgut.rss_app.management.presentation

import android.content.SharedPreferences
import com.antgut.app.serializer.KSerializer
import com.antgut.rss_app.management.data.RssDataRepository
import com.antgut.rss_app.management.data.local.xml.XmlDataSource
import com.antgut.rss_app.management.domain.GetUserUseCase

class ManagerFactory {
    fun getRss(serializer: KSerializer,sharedPreferences: SharedPreferences, ): ManagerViewModel {
        return ManagerViewModel(
            GetUserUseCase(
                RssDataRepository(
                    XmlDataSource(
                        sharedPreferences, serializer
                    )
                )
            )
        )
    }
}