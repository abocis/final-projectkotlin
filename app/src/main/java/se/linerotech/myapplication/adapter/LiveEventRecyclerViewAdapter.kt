package se.linerotech.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import se.linerotech.myapplication.R
import se.linerotech.myapplication.model.Event


class LiveEventRecyclerViewAdapter(private val listOfEvent: List<Event>): RecyclerView.Adapter<LiveEventRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder.create(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //games we show
        val games = listOfEvent[position]

        holder.bind(games )
    }

    override fun getItemCount(): Int = listOfEvent.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

       private val textViewEvent = view.findViewById<TextView>(R.id.textViewEvent)

        fun bind(games: Event){

           // val eventInfo = "${games.homeTeam} vs ${games.awayTeam} - ${games.time}"

           //textViewEvent!!.text = eventInfo

           textViewEvent?.text = games.tournament.toString()

        }
        companion object{
            fun create(parent: ViewGroup): ViewHolder{
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout_recycler_view_event, parent, false)

                return ViewHolder(view)
            }
        }
    }



}