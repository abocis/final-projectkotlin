package se.linerotech.myapplication.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


data class Tournament(
    @SerializedName("category")
    val category: Category? = Category(),
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("priority")
    val priority: Int? = 0,
    @SerializedName("slug")
    val slug: String? = "",
    @SerializedName("uniqueTournament")
    val uniqueTournament: UniqueTournament? = UniqueTournament()
)