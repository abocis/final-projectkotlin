package se.linerotech.myapplication.model


import com.google.gson.annotations.SerializedName

data class RoundInfo(
    @SerializedName("round")
    val round: Int? = 0
)