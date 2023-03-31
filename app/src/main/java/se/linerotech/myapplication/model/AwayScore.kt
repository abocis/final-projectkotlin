package se.linerotech.myapplication.model


import com.google.gson.annotations.SerializedName

data class AwayScore(
    @SerializedName("current")
    val current: Int = 0,
    @SerializedName("display")
    val display: Int = 0,
    @SerializedName("period1")
    val period1: Int = 0
)