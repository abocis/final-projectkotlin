package se.linerotech.myapplication.model


import com.google.gson.annotations.SerializedName

data class AwayTeam(
    @SerializedName("country")
    val country: Country = Country(),
    @SerializedName("gender")
    val gender: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("nameCode")
    val nameCode: String = "",
    @SerializedName("national")
    val national: Boolean = false,
    @SerializedName("shortName")
    val shortName: String = "",
    @SerializedName("slug")
    val slug: String = "",
    @SerializedName("sport")
    val sport: Sport = Sport(),
    @SerializedName("subTeams")
    val subTeams: List<Any> = listOf(),
    @SerializedName("teamColors")
    val teamColors: TeamColors = TeamColors(),
    @SerializedName("type")
    val type: Int = 0,
    @SerializedName("userCount")
    val userCount: Int = 0
)