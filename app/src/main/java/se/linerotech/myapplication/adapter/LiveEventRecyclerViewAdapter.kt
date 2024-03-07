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

class LiveEventRecyclerViewAdapter(private val listOfEvent: List<Event>):
    RecyclerView.Adapter<LiveEventRecyclerViewAdapter.ItemViewHolder>() {

    private lateinit var myListerner: OnItemClickListener


    inner class ItemViewHolder(itemView: View, listener: OnItemClickListener): RecyclerView.ViewHolder(itemView){
        val homeTeamNameTextView : TextView = itemView.findViewById(R.id.textViewHomeTeamName)
        val awayTeamTextView: TextView = itemView.findViewById(R.id.textViewAwayTeamName)
        val scoreTextView: TextView = itemView.findViewById(R.id.textViewScore)
        val matchTimeTextView: TextView = itemView.findViewById(R.id.textViewTime)
        val tournament: TextView = itemView.findViewById(R.id.textViewEventTitle)
        val status: TextView = itemView.findViewById(R.id.textViewVenue)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.layout_recycler_view_event, parent, false)
        return ItemViewHolder(inflatedView, myListerner)

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        //games we show
        val games =  listOfEvent[position]

        holder.homeTeamNameTextView.text = games.homeTeam.shortName
        holder.awayTeamTextView.text = games.awayTeam.shortName
        holder.scoreTextView.text = "${games.homeScore.current} - ${games.awayScore.current}"
        holder.tournament.text = games.tournament.name
        holder.status.text = games.status.type
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = games.time.currentPeriodStartTimestamp * 1000L
        val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        holder.matchTimeTextView.text = timeFormat.format(calendar.time)

    }

    override fun getItemCount(): Int = listOfEvent.size

    interface OnItemClickListener{

        fun onItemClick (position: Int){

        }

    }

    fun setOnItemListener (listener: OnItemClickListener){

        myListerner = listener

    }

}
