package com.antgut.rss_app.management.domain

import com.antgut.rss_app.management.data.retrofit.toDomain

class GetNewsRssUseCase(private val repository: NewsRssRepository){
    fun invoke(url:String):List<NewsUseCaseModel>{
        val list = repository.getNews(url)
        return list.map {
            it.toDomain()
        }
    }
}

data class NewsUseCaseModel(val thumbnail: String, val title:String, val description:String, val link:String, val pubDate:String)