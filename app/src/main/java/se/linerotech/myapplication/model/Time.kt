package se.linerotech.myapplication.model


import com.google.gson.annotations.SerializedName

data class Time(
    @SerializedName("currentPeriodStartTimestamp")
    val currentPeriodStartTimestamp: Int = 0,
    @SerializedName("extra")
    val extra: Int = 0,
    @SerializedName("initial")
    val initial: Int = 0,
    @SerializedName("injuryTime1")
    val injuryTime1: Int = 0,
    @SerializedName("max")
    val max: Int = 0
)