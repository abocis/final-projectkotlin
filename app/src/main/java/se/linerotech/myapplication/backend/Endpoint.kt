package se.linerotech.myapplication.backend

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import se.linerotech.myapplication.model.Event
import se.linerotech.myapplication.model.liveGames

interface Endpoint {

    @Headers("X-RapidAPI-Key: e7e7713dc1msh37199c5b22a5d35p17afa6jsn1772332a2771",
        "X-RapidAPI-Host: footapi7.p.rapidapi.com")
    @GET("api/matches/live")
    fun getLiveGamesEvents(): Call<liveGames>
}