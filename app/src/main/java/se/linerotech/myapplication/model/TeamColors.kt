package se.linerotech.myapplication.model


import com.google.gson.annotations.SerializedName

data class TeamColors(
    @SerializedName("primary")
    val primary: String? = "",
    @SerializedName("secondary")
    val secondary: String? = "",
    @SerializedName("text")
    val text: String? = ""
)