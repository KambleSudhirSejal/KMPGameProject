package com.example.game.domain.repository

import com.example.common.domain.model.Game

interface GameRepository {

    suspend fun getGames(): Result<List<Game>>
}