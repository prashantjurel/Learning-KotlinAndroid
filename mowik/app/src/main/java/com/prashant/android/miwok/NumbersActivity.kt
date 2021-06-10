package com.prashant.android.miwok

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.prashant.android.R

class NumbersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers)

        val numbersList = arrayListOf<String>("One","Two","Three","Four","Five","Six",
            "Seven","Eight","Nine","Ten")

        val itemAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            numbersList)

        val listView = findViewById<ListView>(R.id.list)
        listView.adapter = itemAdapter

    }
}