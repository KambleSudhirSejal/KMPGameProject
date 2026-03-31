package com.example.kmpgameproject.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.game.ui.game.GameScreenUi
import com.example.game.ui.gameDetails.GameDetailScreenUi

object GameNavGraph: BaseNavGraph {

    sealed class Dest(val route:String){
        data object Root:Dest("/game-root")

        data object Game : Dest("/game")

        data object Details:Dest("/game_details/{id}"){
            fun getRoute(id:Int) = "/game_details/${id}"
        }

    }



    override fun build(
        modifier: Modifier,
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation(route = Dest.Root.route, startDestination = Dest.Game.route) {
            composable(route = Dest.Game.route){
                GameScreenUi(
                    modifier = modifier.fillMaxSize(),
                    onFavouriteClick = {},
                    onSearchClick = {
                        navHostController.navigate(SearchNavGraph.Dest.Search.route)
                    },
                    onClick = {
                        navHostController.navigate(Dest.Details.getRoute(it))
                    }


                )



            }

            composable(route = Dest.Details.route){
                val id = it.arguments?.getString("id")
                GameDetailScreenUi(modifier = modifier.fillMaxSize(),id.toString())
            }



        }
    }
}