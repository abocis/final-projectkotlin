package se.linerotech.myapplication.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import se.linerotech.myapplication.R
import se.linerotech.myapplication.model.Event
import java.text.SimpleDateFormat
import java.util.*

class LiveEventRecyclerViewAdapter(private val listOfEvent: List<Event>): RecyclerView.Adapter<LiveEventRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_recycler_view_event, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //games we show
        val games =  listOfEvent[position]

        holder.homeTeamNameTextView.text = games.homeTeam.shortName
        holder.awayTeamTextView.text = games.awayTeam.shortName
        holder.scoreTextView.text = "${games.homeScore.current} - ${games.homeScore.current}"
        holder.tournament.text = games.tournament.name
        holder.status.text = games.status.description; games.status.type


        val calendar = Calendar.getInstance()
        calendar.timeInMillis = games.time.currentPeriodStartTimestamp * 1000L
        val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        holder.matchTimeTextView.text = timeFormat.format(calendar.time)

    }

    override fun getItemCount(): Int = listOfEvent.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val homeTeamNameTextView : TextView = view.findViewById(R.id.textViewHomeTeamName)
        val awayTeamTextView: TextView = view.findViewById(R.id.textViewAwayTeamName)
        val scoreTextView: TextView = view.findViewById(R.id.textViewScore)
        val matchTimeTextView: TextView = view.findViewById(R.id.textViewTime)
        val tournament: TextView = view.findViewById(R.id.textViewEventTitle)
        val status: TextView = view.findViewById(R.id.textViewVenue)

        }

}
