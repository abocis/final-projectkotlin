package se.linerotech.myapplication.model


import com.google.gson.annotations.SerializedName

data class liveGames(
    @SerializedName("events")
    val events: List<Event> = listOf()
)