package com.example.coreNetwork.model.game.game.gameDetails

import kotlinx.serialization.Serializable

@Serializable
data class PlatformXDTO(
    val platform: PlatformXXDTO,
    val released_at: String?,
)