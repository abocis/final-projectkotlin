package se.linerotech.myapplication.model


import com.google.gson.annotations.SerializedName

data class StatusTime(
    @SerializedName("extra")
    val extra: Int? = 0,
    @SerializedName("initial")
    val initial: Int? = 0,
    @SerializedName("max")
    val max: Int? = 0,
    @SerializedName("prefix")
    val prefix: String? = "",
    @SerializedName("timestamp")
    val timestamp: Int? = 0
)