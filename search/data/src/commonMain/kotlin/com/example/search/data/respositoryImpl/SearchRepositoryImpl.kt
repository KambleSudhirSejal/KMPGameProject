package com.example.search.data.respositoryImpl

import com.example.common.domain.model.Game
import com.example.coreNetwork.ApiService.ApiService
import com.example.search.domain.repository.SearchRepository

class SearchRepositoryImpl(
    private val apiService: ApiService
): SearchRepository {
    override suspend fun search(q: String): Result<List<Game>> {

    }
}