package com.antgut.rss_app.management.data.retrofit

import com.antgut.rss_app.management.domain.Models
import com.antgut.rss_app.management.domain.NewsUseCaseModel

fun Models.RssNews.toDomain(): NewsUseCaseModel {
    return NewsUseCaseModel(this.thumbnail, this.title, this.description, this.link, this.pubDate)
}