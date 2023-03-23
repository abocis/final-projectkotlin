package se.linerotech.myapplication.model


import com.google.gson.annotations.SerializedName

data class Status(
    @SerializedName("code")
    val code: Int? = 0,
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("type")
    val type: String? = ""
)