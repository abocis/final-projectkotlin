package se.linerotech.myapplication.model


import com.google.gson.annotations.SerializedName

data class Changes(
    @SerializedName("changeTimestamp")
    val changeTimestamp: Int? = 0,
    @SerializedName("changes")
    val changes: List<String?>? = listOf()
)