package com.example.coreNetwork.model.game.game.gameDetails

import kotlinx.serialization.Serializable

@Serializable
data class Platform(
    val id: Int,
    val name: String,
    val slug: String
)