package se.linerotech.myapplication.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import se.linerotech.myapplication.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set the title of the actionbar
        supportActionBar?.title = getString(R.string.liveMatches)
    }


    //get data for live matches
    private fun getLiveGames (){

    }

}
