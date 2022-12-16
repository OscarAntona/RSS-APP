package com.antgut.rss_app.management.data.local.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.antgut.app.serializer.KSerializer
import com.antgut.rss_app.management.data.local.LocalDataSource
import com.antgut.rss_app.management.domain.ManagementModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map



val Context.dataStore by preferencesDataStore(name = "name_datastore_file")

class DataStoreLocalDataSource (private val context: Context, private val KSerializer: KSerializer){

    suspend fun saveUserRss(url: String, name: String) {
        context.dataStore.edit { preferences ->
            preferences[stringPreferencesKey(url)] = KSerializer.toJson(ManagementModel(url, name), ManagementModel::class.java)
        }
    }

    fun obtainUserRss(): Flow<List<ManagementModel>> {
        return context.dataStore.data
            .map {
                it.asMap().values.map { jsonString ->
                    KSerializer.fromJson(jsonString as String, ManagementModel::class.java)
                }
            }
    }

    suspend fun deleteUserRss(url: String){
        context.dataStore.edit {
            it.remove(stringPreferencesKey(url))
        }
    }

}