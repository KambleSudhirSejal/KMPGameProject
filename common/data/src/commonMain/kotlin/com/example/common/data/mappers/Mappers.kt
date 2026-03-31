package com.example.common.data.mappers

import com.example.common.domain.model.Game
import com.example.coreNetwork.model.game.game.Result


fun List<Result>.toDomainDetails() : List<Game> =map {
    Game(
        id=it.id,
        name = it.name,
        imageUrl = it.background_image


    )

}