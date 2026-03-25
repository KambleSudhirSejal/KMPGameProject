package com.example.game.data.mappers

import com.example.game.domain.model.Game
import com.example.coreNetwork.model.game.Result

fun List<Result>.toDomainDetails() : List<Game> =map {
    Game(
        id=it.id,
        name = it.name,
        imageUrl = it.background_image


    )

}