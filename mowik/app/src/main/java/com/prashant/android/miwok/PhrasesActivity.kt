package com.prashant.android.miwok

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.prashant.android.R

class PhrasesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.words_list)

        val numbersList = arrayListOf<Word>()
        numbersList.add(Word("minto wuksus","Where are you going?"))
        numbersList.add(Word("tinnә oyaase'nә","What is your name?"))
        numbersList.add(Word("oyaaset..","My name is..."))
        numbersList.add(Word("michәksәs?","How are you feeling?"))
        numbersList.add(Word("kuchi achit","I’m feeling good."))
        numbersList.add(Word("әәnәs'aa?","Are you coming?"))
        numbersList.add(Word("hәә’ әәnәm","Yes, I’m coming."))
        numbersList.add(Word("әәnәm","I’m coming."))
        numbersList.add(Word("yoowutis","Let’s go."))
        numbersList.add(Word("әnni'nem","Come here."))

        val itemAdapter = WordAdapter(this, numbersList,R.color.category_phrases)

        val listView = findViewById<ListView>(R.id.list)
        listView.adapter = itemAdapter

    }
}