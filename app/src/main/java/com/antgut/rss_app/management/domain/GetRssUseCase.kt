package com.antgut.rss_app.management.domain

class GetRssUseCase  (private val repository: RssRepository){
    suspend fun execute():List<ManagementModel>{
        return repository.getRss()
    }
}