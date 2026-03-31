package com.example.coreNetwork.model.game.game

import kotlinx.serialization.Serializable

@Serializable
data class GameResponse(

    val results: List<Result>,

    )