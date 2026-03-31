package com.example.game.ui.gameDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.game.domain.model.GameDetails
import com.example.game.domain.useCases.GetGameDetailUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update

class GameDetailViewModel(
    private val getGameDetailUseCase: GetGameDetailUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(GameDetailScreen.UiState())

    val uiState = _uiState.asStateFlow()

    fun getGameDetails(id:Int){
        getGameDetailUseCase.invoke(id)
            .onStart {
                _uiState.update { GameDetailScreen.UiState(isLoading = true) }
            }.onEach {result->
                result.onSuccess { data ->
                    _uiState.update {
                        GameDetailScreen.UiState(data=data)
                    }

                }.onFailure {error ->
                    _uiState.update {
                        GameDetailScreen.UiState(error = error.message.toString())
                    }


                }


            }.launchIn(viewModelScope)
    }

}

data object GameDetailScreen{
    data class UiState(
        val  isLoading:Boolean = false,
        val error:String = "",
        val data: GameDetails? = null
    )
}
