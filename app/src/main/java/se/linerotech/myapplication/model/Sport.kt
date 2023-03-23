package se.linerotech.myapplication.model


import com.google.gson.annotations.SerializedName

data class Sport(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("slug")
    val slug: String? = ""
)