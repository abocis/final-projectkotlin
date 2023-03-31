package se.linerotech.myapplication.model


import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("awayScore")
    val awayScore: AwayScore = AwayScore(),
    @SerializedName("awayTeam")
    val awayTeam: AwayTeam = AwayTeam(),
    @SerializedName("changes")
    val changes: Changes = Changes(),
    @SerializedName("customId")
    val customId: String = "",
    @SerializedName("finalResultOnly")
    val finalResultOnly: Boolean = false,
    @SerializedName("hasGlobalHighlights")
    val hasGlobalHighlights: Boolean = false,
    @SerializedName("homeScore")
    val homeScore: HomeScore = HomeScore(),
    @SerializedName("homeTeam")
    val homeTeam: HomeTeam = HomeTeam(),
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("lastPeriod")
    val lastPeriod: String = "",
    @SerializedName("roundInfo")
    val roundInfo: RoundInfo = RoundInfo(),
    @SerializedName("slug")
    val slug: String = "",
    @SerializedName("startTimestamp")
    val startTimestamp: Int = 0,
    @SerializedName("status")
    val status: Status = Status(),
    @SerializedName("statusTime")
    val statusTime: StatusTime = StatusTime(),
    @SerializedName("time")
    val time: Time = Time(),
    @SerializedName("tournament")
    val tournament: Tournament = Tournament(),
    @SerializedName("winnerCode")
    val winnerCode: Int = 0
)