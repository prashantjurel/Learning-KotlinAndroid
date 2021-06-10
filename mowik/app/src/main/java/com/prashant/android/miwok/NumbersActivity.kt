package com.prashant.android.miwok

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.prashant.android.R

class NumbersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers)

        val layout = findViewById<LinearLayout>(R.id.rootView)

        val numbersList = arrayListOf<String>("One","Two","Three","Four","Five","Six",
            "Seven","Eight","Nine","Ten")
        var i = 0

        for(item in numbersList){
            val wordView = TextView(this)
            wordView.text = item
            layout?.addView(wordView)
        }

    }
}