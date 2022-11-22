package com.antgut.rss_app.management.domain

class SaveRssUseCase(val repository: RssRepository) {
    suspend fun execute(url: String, name: String) {
        repository.saveRss(url,name)
    }
}