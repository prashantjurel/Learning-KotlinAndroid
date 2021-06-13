package com.prashant.android.miwok

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.prashant.android.R

class FamilyActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer = MediaPlayer().apply {
        setOnPreparedListener { start() }
        setOnCompletionListener { reset() }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.words_list)

        val numbersList = arrayListOf<Word>()
        numbersList.add(Word("әpә","Father",R.drawable.family_father,R.raw.family_father))
        numbersList.add(Word("әṭa","Mother",R.drawable.family_mother,R.raw.family_mother))
        numbersList.add(Word("angsi","Son",R.drawable.family_son,R.raw.family_son))
        numbersList.add(Word("tune","Daughter",R.drawable.family_daughter,R.raw.family_daughter))
        numbersList.add(Word("taachi","Older brother",R.drawable.family_older_brother,R.raw.family_older_brother))
        numbersList.add(Word("chalitti","Younger Brother",R.drawable.family_younger_brother,R.raw.family_younger_brother))
        numbersList.add(Word("teṭe","older sister",R.drawable.family_older_sister,R.raw.family_older_sister))
        numbersList.add(Word("kolliti","younger sister",R.drawable.family_younger_sister,R.raw.family_younger_sister))
        numbersList.add(Word("ama","grandmother",R.drawable.family_grandmother,R.raw.family_grandmother))
        numbersList.add(Word("pappa","grandfather",R.drawable.family_grandfather,R.raw.family_grandfather))

        val itemAdapter = WordAdapter(this, numbersList,R.color.category_family)

        val listView = findViewById<ListView>(R.id.list)
        listView.adapter = itemAdapter
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            mediaPlayer.reset()
            mediaPlayer = MediaPlayer.create(this, numbersList[position].audio)
            mediaPlayer.start()
            mediaPlayer.setOnCompletionListener { mediaPlayer.release() }
        }

    }
}