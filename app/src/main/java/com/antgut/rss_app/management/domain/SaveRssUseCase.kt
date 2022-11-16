package com.antgut.rss_app.management.domain

class SaveRssUseCase(val repository: RssRepository) {
    fun execute(name: String, url: String) {
        repository.saveRss(ManagementModel(name, url))
    }
}