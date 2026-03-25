package com.example.game.data.repository

import com.example.coreNetwork.ApiService.ApiService
import com.example.game.data.mappers.toDomainDetails
import com.example.game.domain.model.Game
import com.example.game.domain.repository.GameRepository

class GameRepositoryImpl(private val apiService: ApiService): GameRepository {
    override suspend fun getGames(): Result<List<Game>> {
        val result = apiService.getGames()
        return if(result.isSuccess){
            Result.success(result.getOrThrow().results.toDomainDetails())
        }else{
            Result.failure(result.exceptionOrNull()!!)
        }
    }
}