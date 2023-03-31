package se.linerotech.myapplication.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import se.linerotech.myapplication.R
import se.linerotech.myapplication.backend.RetrofitClient
import se.linerotech.myapplication.model.Event
import retrofit2.Callback
import retrofit2.Response
import se.linerotech.myapplication.adapter.LiveEventRecyclerViewAdapter
import se.linerotech.myapplication.model.liveGames

class MainActivity : AppCompatActivity() {

    var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //set the title of the actionbar
        supportActionBar?.title = getString(R.string.liveMatches)

        //initialize variables
        progressBar = findViewById(R.id.mainActivityProgressbar)

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

                        Log.d(TAG, "Response successful")

                        //show the item to the user
                        val events = response.body()?.events?.distinctBy { it.homeScore }?: emptyList()

                        showItems(events)


                    }else{

                        Log.d(TAG, "Response unsuccessful. Error code: ${response.code()}")


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
    private fun showItems(Events: List<Event>){
        //stop the progress bar
        progressBar?.visibility = View.GONE

        //initialize the adapter
        val recyclerViewAdapter = LiveEventRecyclerViewAdapter(Events)

        // connect the adapter to the recycler view
        val recyclerView = findViewById<RecyclerView>(R.id.mainActivityRecyclerView)
        recyclerView?.apply {
            setHasFixedSize(true)
            adapter = recyclerViewAdapter
            layoutManager = LinearLayoutManager(context)
            visibility = View.VISIBLE
        }

    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }



}
