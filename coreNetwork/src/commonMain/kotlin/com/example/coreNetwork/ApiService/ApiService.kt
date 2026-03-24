package com.example.coreNetwork.ApiService

import com.example.coreNetwork.model.game.GameResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kmpgameproject.corenetwork.generated.resources.Res

class ApiService(val httpClient : HttpClient) {

    // https://api.rawg.io/api/games?key=a646469a2fff4451963bafa6622ebd75

    suspend fun getGames(): Result<GameResponse>{
        return try{

            val response = httpClient.get("api/games"){
                url{
                    parameter("key","a646469a2fff4451963bafa6622ebd75")
                }


            }.body<GameResponse>()
            Result.success(response)


        }catch (e: Exception){
            Result.failure(e)
        }

    }

    suspend fun search(q:String):Result<GameResponse>{
        return try{
            val response = httpClient.get("api/games") {
                url {
                    parameter("key", "a646469a2fff4451963bafa6622ebd75")
                    parameter("search", q)
                }
            }.body<GameResponse>()
            Result.success(response)
        }catch (e: Exception){
            Result.failure(e)
        }
    }

    suspend fun getDetails(id: Int): Result<GameResponse> {
        return try {
            val response = httpClient.get("api/games/${id}") {
                url {
                    parameter("key", "a646469a2fff4451963bafa6622ebd75")
                }
            }.body<GameResponse>()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }

    }


}