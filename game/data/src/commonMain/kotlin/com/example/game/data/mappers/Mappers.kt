package com.example.game.data.mappers


import com.example.game.domain.model.Developer
import com.example.game.domain.model.GameDetails
import com.example.game.domain.model.Platform
import gaur.himanshu.coreNetwork.model.gameDetails.GameDetailsResponse

import com.example.game.domain.model.Store
import com.example.game.domain.model.Tag


fun GameDetailsResponse.toDomainGameDetails(): GameDetails  {
   return GameDetails(
        name = name,
        id=id,
        description =description_raw,
        backgroundImage = background_image,
        additionImage = background_image_additional,
        platform = platforms.map {
            Platform(
                name=it.platform.name,
                image = it.platform.image_background
            )
        },
        stores= stores.map {
            Store(
                name = it.store.name,
                image = it.store.image_background,
                gameCount = it.store.games_count,
                domain = it.store.domain
            )
        },
        developers=developers.map{
            Developer(
                name = it.name,
                image = it.image_background,
                gameCount = it.games_count
            )
        },
        tags=tags.map{
            Tag(

                name = it.name,
                image = it.image_background
            )
        }
    )

}
