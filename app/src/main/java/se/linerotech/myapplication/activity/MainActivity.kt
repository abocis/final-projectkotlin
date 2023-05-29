package se.linerotech.myapplication.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import se.linerotech.myapplication.R
import se.linerotech.myapplication.adapter.LiveEventRecyclerViewAdapter
import se.linerotech.myapplication.backend.RetrofitClient
import se.linerotech.myapplication.model.Event
import se.linerotech.myapplication.model.liveGames

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //set the title of the actionbar
        supportActionBar?.title = getString(R.string.app_name)

        //initialize variables
      //  progressBar = findViewById(R.id.mainActivityProgressbar)

        getLiveEvent()
    }

    //get data for live matches
    private fun getLiveEvent() {

        RetrofitClient
            .instance
            .getLiveGamesEvents()
            .enqueue(object : Callback<liveGames> {

                override fun onResponse(call: Call<liveGames>, response: Response<liveGames>) {

                    if(response.isSuccessful){

                      //  Log.d(TAG, "Response successful")

                        //show the item to the user
                        val events = response.body()?.events ?: emptyList()

                        displayEvents(events, this@MainActivity)

                    }else{

                       // Log.d(TAG, "Response unsuccessful. Error code: ${response.code()}")

                        //Created a message based on the error code
                        val message = when(response.code()){
                            500 -> R.string.internal_server_error
                            401 -> R.string.unauthorized
                            403 ->R.string.forbidden
                            404 -> R.string.game_not_found
                            else -> R.string.try_another_game
                        }
                        Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
                         Log.e(TAG, "error $response")
                    }
                }
                override fun onFailure(call: Call<liveGames>, t: Throwable) {
                    //show the error the user
                    Toast.makeText(this@MainActivity,
                        R.string.unable_to_get_livevent,
                        Toast.LENGTH_LONG
                    ).show()
                    //Log the error
                    Log.e(TAG, "Error getting events: ${t.localizedMessage}")
                }
            })
    }
    private fun displayEvents(events: List<Event>, mainActivity: MainActivity){

        //initialize the adapter with the event list and set up the item click listener
        val recyclerViewAdapter = LiveEventRecyclerViewAdapter(events).apply {
            setOnItemListener(object : LiveEventRecyclerViewAdapter.OnItemClickListener {

                override fun onItemClick(position: Int) {
                    //   Toast.makeText(mainActivity, "Clicked: $position", Toast.LENGTH_SHORT).show()

                    //handle item click event

                    val selectedEvent = events[position]
                    EventStorage.setEvent(selectedEvent)
                    val intent = Intent(this@MainActivity, GameDetailsActivity::class.java)

                    startActivity(intent)

                }
            })
        }
        // connect the adapter to the recycler view
        val recyclerView = findViewById<RecyclerView>(R.id.mainActivityRecyclerView)
        recyclerView?.apply {
            setHasFixedSize(true)
            adapter = recyclerViewAdapter
            layoutManager = LinearLayoutManager(context)
            visibility = View.VISIBLE
        }
    }

    object EventStorage{
        private var event: Event? = null
        fun setEvent(event: Event){
            this.event= event
        }

        fun getEvent(): Event?{
            return event
        }
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

}
