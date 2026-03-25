package com.example.game.ui.di

import org.koin.dsl.module
import com.example.game.ui.game.GameViewModel
import org.koin.core.module.dsl.viewModel

fun getGameUiModule()=module {
    viewModel { GameViewModel(getGamesUseCase = get()) }

}