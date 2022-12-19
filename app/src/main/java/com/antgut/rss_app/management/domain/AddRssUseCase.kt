package com.antgut.rss_app.management.domain

class AddRssUseCase(private val repository: RssRepository) {
    suspend fun invoke(url:String, name: String){
        repository.saveRssUser(url, name)
    }
}