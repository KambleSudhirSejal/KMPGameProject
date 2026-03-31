package com.example.game.domain.di

import com.example.game.domain.useCases.GetGamesUseCase
import com.example.game.domain.useCases.GetGameDetailUseCase
import org.koin.dsl.module

fun getGameDomainModule() = module {
    factory {
        GetGamesUseCase(gameRepository = get())

    }
    factory{GetGameDetailUseCase(gameRepository = get())}

}