package com.prashant.android.miwok

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.prashant.android.R

class NumbersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category);
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, NumbersFragment())
            .commit();
    }

}

