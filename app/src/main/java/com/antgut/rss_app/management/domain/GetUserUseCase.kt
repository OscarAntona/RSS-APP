package com.antgut.rss_app.management.domain

import kotlinx.coroutines.flow.Flow

class GetUserUseCase(private val repository: RssRepository){
    suspend fun invoke(): Flow<List<ManagementModel>> {
        return repository.getRssUser()
    }
}