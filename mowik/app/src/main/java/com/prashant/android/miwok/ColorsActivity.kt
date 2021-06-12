package com.prashant.android.miwok

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.prashant.android.R

class ColorsActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.words_list)
        val numbersList = arrayListOf<Word>()
        numbersList.add(Word("weṭeṭṭi","red",R.drawable.color_red,R.raw.color_red))
        numbersList.add(Word("chokokki","green",R.drawable.color_green,R.raw.color_green))
        numbersList.add(Word("ṭakaakki","brown",R.drawable.color_brown,R.raw.color_brown))
        numbersList.add(Word("ṭopoppi","gray",R.drawable.color_gray,R.raw.color_gray))
        numbersList.add(Word("kululli","black",R.drawable.color_black,R.raw.color_black))
        numbersList.add(Word("kelelli","white",R.drawable.color_white,R.raw.color_white))
        numbersList.add(Word("ṭopiisә","dusty yellow",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow))
        numbersList.add(Word("chiwiiṭә","mustard yellow",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow))

        val itemAdapter = WordAdapter(this, numbersList,R.color.category_colors)

        val listView = findViewById<ListView>(R.id.list)
        listView.adapter = itemAdapter
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            mediaPlayer = MediaPlayer.create(this, numbersList[position].audio)
            mediaPlayer.start()
        }
    }
}