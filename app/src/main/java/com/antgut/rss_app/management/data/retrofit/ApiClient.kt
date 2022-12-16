package com.antgut.rss_app.management.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class ApiClient {

    private val apiServices: ApiServices

    init {
        apiServices = getApiClient()
    }

    private fun getApiClient() =
        createRetrofitClient().create(ApiServices::class.java)

    private fun createRetrofitClient() = Retrofit.Builder()
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .baseUrl("https://github.com")
        .build();

    suspend fun getRss(urlRss: String) = apiServices.getRss(urlRss).body()!!

}