package com.prashant.android.miwok

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.prashant.android.R

class FamilyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.words_list)

        val numbersList = arrayListOf<Word>()
        numbersList.add(Word("әpә","Father"))
        numbersList.add(Word("әṭa","Mother"))
        numbersList.add(Word("angsi","Son"))
        numbersList.add(Word("tune","Daughter"))
        numbersList.add(Word("taachi","Older brother"))
        numbersList.add(Word("chalitti","Younger Brother"))
        numbersList.add(Word("teṭe","older sister"))
        numbersList.add(Word("kolliti","younger sister"))
        numbersList.add(Word("ama","grandmother"))
        numbersList.add(Word("pappa","grandfather"))

        val itemAdapter = WordAdapter(this, numbersList)

        val listView = findViewById<ListView>(R.id.list)
        listView.adapter = itemAdapter

    }
}