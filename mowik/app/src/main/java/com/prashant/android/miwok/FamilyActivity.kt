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
        numbersList.add(Word("әpә","Father",R.drawable.family_father))
        numbersList.add(Word("әṭa","Mother",R.drawable.family_mother))
        numbersList.add(Word("angsi","Son",R.drawable.family_son))
        numbersList.add(Word("tune","Daughter",R.drawable.family_daughter))
        numbersList.add(Word("taachi","Older brother",R.drawable.family_older_brother))
        numbersList.add(Word("chalitti","Younger Brother",R.drawable.family_younger_brother))
        numbersList.add(Word("teṭe","older sister",R.drawable.family_older_sister))
        numbersList.add(Word("kolliti","younger sister",R.drawable.family_younger_sister))
        numbersList.add(Word("ama","grandmother",R.drawable.family_grandmother))
        numbersList.add(Word("pappa","grandfather",R.drawable.family_grandfather))

        val itemAdapter = WordAdapter(this, numbersList)

        val listView = findViewById<ListView>(R.id.list)
        listView.adapter = itemAdapter

    }
}