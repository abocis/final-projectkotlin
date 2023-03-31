package se.linerotech.myapplication.model


import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("alpha2")
    val alpha2: String = "",
    @SerializedName("flag")
    val flag: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("slug")
    val slug: String = "",
    @SerializedName("sport")
    val sport: Sport = Sport()
)