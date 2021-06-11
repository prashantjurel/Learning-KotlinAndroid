package com.prashant.android.miwok

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.prashant.android.R

class NumbersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.words_list)

        val numbersList = arrayListOf<Word>()
        numbersList.add(Word("lutti","one"))
        numbersList.add(Word("otiiko","two"))
        numbersList.add(Word("tolookosu","three"))
        numbersList.add(Word("oyyisa","four"))
        numbersList.add(Word("massokka","five"))
        numbersList.add(Word("temmokka","six"))
        numbersList.add(Word("kenekaku","seven"))
        numbersList.add(Word("kawinta","eight"))
        numbersList.add(Word("wo’e","nine"))
        numbersList.add(Word("na’aacha","ten"))

        val itemAdapter = WordAdapter(this, numbersList)

        val listView = findViewById<ListView>(R.id.list)
        listView.adapter = itemAdapter

    }
}