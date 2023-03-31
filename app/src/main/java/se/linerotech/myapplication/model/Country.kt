package se.linerotech.myapplication.model


import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("alpha2")
    val alpha2: String = "",
    @SerializedName("name")
    val name: String = ""
)