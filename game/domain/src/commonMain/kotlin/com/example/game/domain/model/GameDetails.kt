package com.example.game.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Game(
    val id :Int,
    val name:String,
    val imageUrl:String
)