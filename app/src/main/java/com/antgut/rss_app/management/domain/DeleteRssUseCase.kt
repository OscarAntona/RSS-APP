package com.antgut.rss_app.management.domain

class DeleteRssUseCase (val repository: RssRepository) {
    suspend fun invoke(url:String){
        repository.deleteRss(url)
    }
}