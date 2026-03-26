package com.example.common.data.mappers

import com.example.common.domain.model.Game


fun List<com.example.coreNetwork.model.game.Result>.toDomainDetails() : List<Game> =map {
    Game(
        id=it.id,
        name = it.name,
        imageUrl = it.background_image


    )

}