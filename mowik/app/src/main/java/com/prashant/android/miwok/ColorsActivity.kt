package com.prashant.android.miwok

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.prashant.android.R

class ColorsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.words_list)
        val numbersList = arrayListOf<Word>()
        numbersList.add(Word("weṭeṭṭi","red",R.drawable.color_red))
        numbersList.add(Word("chokokki","green",R.drawable.color_green))
        numbersList.add(Word("ṭakaakki","brown",R.drawable.color_brown))
        numbersList.add(Word("ṭopoppi","gray",R.drawable.color_gray))
        numbersList.add(Word("kululli","black",R.drawable.color_black))
        numbersList.add(Word("kelelli","white",R.drawable.color_white))
        numbersList.add(Word("ṭopiisә","dusty yellow",R.drawable.color_dusty_yellow))
        numbersList.add(Word("chiwiiṭә","mustard yellow",R.drawable.color_mustard_yellow))

        val itemAdapter = WordAdapter(this, numbersList,R.color.category_colors)

        val listView = findViewById<ListView>(R.id.list)
        listView.adapter = itemAdapter
    }
}