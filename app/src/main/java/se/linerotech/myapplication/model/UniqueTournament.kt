package se.linerotech.myapplication.model


import com.google.gson.annotations.SerializedName

data class UniqueTournament(
    @SerializedName("category")
    val category: Category = Category(),
    @SerializedName("country")
    val country: CountryXX = CountryXX(),
    @SerializedName("crowdsourcingEnabled")
    val crowdsourcingEnabled: Boolean = false,
    @SerializedName("displayInverseHomeAwayTeams")
    val displayInverseHomeAwayTeams: Boolean = false,
    @SerializedName("hasEventPlayerStatistics")
    val hasEventPlayerStatistics: Boolean = false,
    @SerializedName("hasPerformanceGraphFeature")
    val hasPerformanceGraphFeature: Boolean = false,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("slug")
    val slug: String = "",
    @SerializedName("userCount")
    val userCount: Int = 0
)