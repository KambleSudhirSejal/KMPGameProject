package com.example.coreNetwork.model.game.game.gameDetails

import kotlinx.serialization.Serializable

@Serializable
data class StoreDTO(
    val id: Int,
    val store: StoreXDTO
)