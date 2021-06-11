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
        numbersList.add(Word("weṭeṭṭi","red"))
        numbersList.add(Word("chokokki","green"))
        numbersList.add(Word("ṭakaakki","brown"))
        numbersList.add(Word("oyyisa","four"))
        numbersList.add(Word("ṭopoppi","gray"))
        numbersList.add(Word("temmokka","six"))
        numbersList.add(Word("kululli","black"))
        numbersList.add(Word("kelelli","white"))
        numbersList.add(Word("ṭopiisә","dusty yellow"))
        numbersList.add(Word("chiwiiṭә","mustard yellow"))

        val itemAdapter = WordAdapter(this, numbersList)

        val listView = findViewById<ListView>(R.id.list)
        listView.adapter = itemAdapter
    }
}