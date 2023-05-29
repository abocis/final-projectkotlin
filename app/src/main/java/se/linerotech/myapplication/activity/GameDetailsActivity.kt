package se.linerotech.myapplication.activity

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import se.linerotech.myapplication.R
import se.linerotech.myapplication.R.id.textViewTournementTitle
import se.linerotech.myapplication.SubteamsAdapter
import se.linerotech.myapplication.model.Event
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class GameDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_details)

        val eventDetails = MainActivity.EventStorage.getEvent()



        val tournamentTittle: TextView = findViewById(textViewTournementTitle)
        val homeTeamDetails: TextView = findViewById(R.id.textViewTeamA)
        val awayTeamDetails: TextView = findViewById(R.id.textViewTeamB)
        val scoreDetails: TextView = findViewById(R.id.textViewResult)
        val dateDetails: TextView = findViewById(R.id.textViewDate)
        val evenStatus : TextView = findViewById(R.id.statusDetails)
        val venueDetails : TextView = findViewById(R.id.textViewVenue)
        val teamALineUp : RecyclerView = findViewById(R.id.lineUpTeamA)


        tournamentTittle.text = eventDetails?.tournament?.name
        homeTeamDetails.text = eventDetails?.homeTeam?.name
        awayTeamDetails.text = eventDetails?.awayTeam?.name
        scoreDetails.text = "${eventDetails?.homeScore?.current} - ${eventDetails?.awayScore?.current}"
        evenStatus.text = eventDetails?.status?.description
        // Calculate the elapsed time in milliseconds
        val currentTimestamp = System.currentTimeMillis() / 1000 // Convert to seconds
        val startTimestamp = eventDetails?.startTimestamp ?: 0
        val elapsedMillis = (currentTimestamp - startTimestamp) * 1000 // Convert to milliseconds
// Format the elapsed time to display the current period timestamp
        val elapsedSeconds = elapsedMillis / 1000
        val minutes = elapsedSeconds / 60
        val seconds = elapsedSeconds % 60
        val currentTime = String.format("%02d:%02d", minutes, seconds)
        dateDetails.text = currentTime

    }
}