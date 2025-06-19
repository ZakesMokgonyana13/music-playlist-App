package com.example.musicplaylist

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var titleInput: EditText
    private lateinit var artistInput: EditText
    private lateinit var ratingInput: EditText
    private lateinit var commentInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleInput = findViewById(R.id.inputTitle)
        artistInput = findViewById(R.id.inputArtist)
        ratingInput = findViewById(R.id.inputRating)
        commentInput = findViewById(R.id.inputComment)

        val addBtn = findViewById<Button>(R.id.btnAdd)
        val nextBtn = findViewById<Button>(R.id.btnNextScreen)
        val exitBtn = findViewById<Button>(R.id.btnExit)

        addBtn.setOnClickListener {
            val title = titleInput.text.toString().trim()
            val artist = artistInput.text.toString().trim()
            val rating = ratingInput.text.toString().toIntOrNull()
            val comment = commentInput.text.toString().trim()

            if (title.isNotEmpty() && artist.isNotEmpty() && rating != null && rating in 1..5) {
                PlaylistData.songs.add(title)
                PlaylistData.artists.add(artist)
                PlaylistData.ratings.add(rating)
                PlaylistData.comments.add(comment)

                Toast.makeText(this, "Song added!", Toast.LENGTH_SHORT).show()
                titleInput.text.clear()
                artistInput.text.clear()
                ratingInput.text.clear()
                commentInput.text.clear()
            } else {
                Toast.makeText(this, "Please enter valid song details", Toast.LENGTH_SHORT).show()
            }
        }

        nextBtn.setOnClickListener {
            startActivity(Intent(this, SecondScreenActivity::class.java))
        }

        exitBtn.setOnClickListener {
            finishAffinity()
        }
    }
}