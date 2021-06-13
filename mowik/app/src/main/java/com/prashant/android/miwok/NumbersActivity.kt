package com.prashant.android.miwok

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.prashant.android.R

class NumbersActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer = MediaPlayer().apply {
        setOnPreparedListener { start() }
        setOnCompletionListener { reset() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.words_list)

        val numbersList = arrayListOf<Word>()
        numbersList.add(Word("lutti", "one", R.drawable.number_one, R.raw.number_one))
        numbersList.add(Word("otiiko", "two", R.drawable.number_two, R.raw.number_two))
        numbersList.add(Word("tolookosu", "three", R.drawable.number_three, R.raw.number_three))
        numbersList.add(Word("oyyisa", "four", R.drawable.number_four, R.raw.number_four))
        numbersList.add(Word("massokka", "five", R.drawable.number_five, R.raw.number_five))
        numbersList.add(Word("temmokka", "six", R.drawable.number_six, R.raw.number_six))
        numbersList.add(Word("kenekaku", "seven", R.drawable.number_seven, R.raw.number_seven))
        numbersList.add(Word("kawinta", "eight", R.drawable.number_eight, R.raw.number_eight))
        numbersList.add(Word("wo’e", "nine", R.drawable.number_nine, R.raw.number_nine))
        numbersList.add(Word("na’aacha", "ten", R.drawable.number_ten, R.raw.number_ten))

        val itemAdapter = WordAdapter(this, numbersList, R.color.category_numbers)

        val listView = findViewById<ListView>(R.id.list)
        listView.adapter = itemAdapter
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            mediaPlayer.reset()
            mediaPlayer = MediaPlayer.create(this, numbersList[position].audio)
            mediaPlayer.start()
        }
    }
}