package com.example.musicplaylist

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class SecondScreenActivity : AppCompatActivity() {

    private lateinit var outputText: TextView
    private lateinit var showSongsBtn: Button
    private lateinit var avgRatingBtn: Button
    private lateinit var backBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

        outputText = findViewById(R.id.outputText)
        showSongsBtn = findViewById(R.id.btnShowSongs)
        avgRatingBtn = findViewById(R.id.btnAverage)
        backBtn = findViewById(R.id.btnBack)

        showSongsBtn.setOnClickListener {
            val builder = StringBuilder()
            for (i in PlaylistData.songs.indices) {
                builder.append("Song: ${PlaylistData.songs[i]}\n")
                builder.append("Artist: ${PlaylistData.artists[i]}\n")
                builder.append("Rating: ${PlaylistData.ratings[i]}\n")
                builder.append("Comment: ${PlaylistData.comments[i]}\n\n")
            }
            outputText.text = builder.toString()
        }

        avgRatingBtn.setOnClickListener {
            if (PlaylistData.ratings.isNotEmpty()) {
                val total = PlaylistData.ratings.sum().toDouble()
                val avg = total / PlaylistData.ratings.size
                outputText.text = "Average Rating: " + String.format("%.2f", avg)
            } else {
                outputText.text = "No ratings to calculate."
            }
        }

        backBtn.setOnClickListener {
            finish()
        }
    }
}