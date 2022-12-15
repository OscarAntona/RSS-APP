package com.antgut.rss_app.management.domain

class GetUserUseCase(private val repository: RssRepository){
    suspend fun execute():List<ManagementModel>{
        return repository.getRssUser()
    }
}