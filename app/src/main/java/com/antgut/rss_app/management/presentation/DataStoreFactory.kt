package com.antgut.rss_app.management.presentation

import android.content.Context
import com.antgut.app.serializer.GsonSerializer
import com.antgut.rss_app.management.data.RssDataRepository
import com.antgut.rss_app.management.data.local.datastore.DataStoreLocalDataSource
import com.antgut.rss_app.management.domain.AddRssUseCase
import com.antgut.rss_app.management.domain.DeleteRssUseCase
import com.antgut.rss_app.management.domain.GetUserUseCase

class DataStoreFactory {
    fun injectViewModel(context: Context): RssDataStoreViewModel {
        val repository = injectRepository(context)
        return RssDataStoreViewModel(
            GetUserUseCase(repository),
            AddRssUseCase(repository),
            DeleteRssUseCase(repository)
        )
    }

    private fun injectRepository(context: Context) =
        RssDataRepository(DataStoreLocalDataSource(context, GsonSerializer()))

}