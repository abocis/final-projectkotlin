package se.linerotech.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SubteamsAdapter ( private val subTeamList: List<Any>)
    : RecyclerView.Adapter<SubteamsAdapter.SubTeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubTeamViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_game_details, parent, false)
        return SubTeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubTeamViewHolder, position: Int) {
        val subTeam = subTeamList[position]
        holder.bind(subTeam)

    }


    override fun getItemCount(): Int {
        return subTeamList.size
    }

    inner class SubTeamViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(subTeam: Any) {

        }

    }


}

