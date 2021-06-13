package com.prashant.android.miwok

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.prashant.android.R

class PhrasesActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer = MediaPlayer().apply {
        setOnCompletionListener {
            reset()
            release()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.words_list)

        val numbersList = arrayListOf<Word>()
        numbersList.add(
            Word(
                "minto wuksus",
                "Where are you going?",
                R.raw.phrase_where_are_you_going
            )
        )
        numbersList.add(
            Word(
                "tinnә oyaase'nә",
                "What is your name?",
                R.raw.phrase_what_is_your_name
            )
        )
        numbersList.add(Word("oyaaset..", "My name is...", R.raw.phrase_my_name_is))
        numbersList.add(
            Word(
                "michәksәs?",
                "How are you feeling?",
                R.raw.phrase_how_are_you_feeling
            )
        )
        numbersList.add(Word("kuchi achit", "I’m feeling good.", R.raw.phrase_im_feeling_good))
        numbersList.add(Word("әәnәs'aa?", "Are you coming?", R.raw.phrase_are_you_coming))
        numbersList.add(Word("hәә’ әәnәm", "Yes, I’m coming.", R.raw.phrase_yes_im_coming))
        numbersList.add(Word("әәnәm", "I’m coming.", R.raw.phrase_im_coming))
        numbersList.add(Word("yoowutis", "Let’s go.", R.raw.phrase_lets_go))
        numbersList.add(Word("әnni'nem", "Come here.", R.raw.phrase_come_here))

        val itemAdapter = WordAdapter(this, numbersList, R.color.category_phrases)

        val listView = findViewById<ListView>(R.id.list)
        listView.adapter = itemAdapter
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer.create(this, numbersList[position].audio)
            mediaPlayer.start()
        }

    }
    override fun onStop() {
        super.onStop()
        mediaPlayer.stop()
        mediaPlayer?.reset()
        mediaPlayer?.release()
    }
}