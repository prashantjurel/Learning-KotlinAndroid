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
        numbersList.add(Word("lutti","one", R.drawable.number_one))
        numbersList.add(Word("otiiko","two",R.drawable.number_two))
        numbersList.add(Word("tolookosu","three",R.drawable.number_three))
        numbersList.add(Word("oyyisa","four",R.drawable.number_four))
        numbersList.add(Word("massokka","five",R.drawable.number_five))
        numbersList.add(Word("temmokka","six",R.drawable.number_six))
        numbersList.add(Word("kenekaku","seven",R.drawable.number_seven))
        numbersList.add(Word("kawinta","eight",R.drawable.number_eight))
        numbersList.add(Word("wo’e","nine",R.drawable.number_nine))
        numbersList.add(Word("na’aacha","ten",R.drawable.number_ten))

        val itemAdapter = WordAdapter(this, numbersList)

        val listView = findViewById<ListView>(R.id.list)
        listView.adapter = itemAdapter

    }
}