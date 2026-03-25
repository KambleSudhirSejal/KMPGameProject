package com.example.game.domain.repository

import com.example.game.domain.model.Game

interface GameRepository {

    suspend fun getGames(): Result<List<Game>>
}