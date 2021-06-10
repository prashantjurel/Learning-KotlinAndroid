package com.prashant.android.miwok

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.prashant.android.R

class MainActivity : AppCompatActivity() {

    private lateinit var numbersBtn : TextView
    private lateinit var familyBtn : TextView
    private lateinit var colorsBtn : TextView
    private lateinit var phrasesBtn : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numbersBtn = findViewById(R.id.numbers)
        familyBtn = findViewById(R.id.family)
        colorsBtn = findViewById(R.id.colors)
        phrasesBtn = findViewById(R.id.phrases)

        numbersBtn.setOnClickListener{
            val intent = Intent(this,NumbersActivity::class.java)
            startActivity(intent)
        }
        familyBtn.setOnClickListener{
            val intent = Intent(this,FamilyActivity::class.java)
            startActivity(intent)
        }
        colorsBtn.setOnClickListener{
            val intent = Intent(this,ColorsActivity::class.java)
            startActivity(intent)
        }
        phrasesBtn.setOnClickListener{
            val intent = Intent(this,PhrasesActivity::class.java)
            startActivity(intent)
        }
    }

}