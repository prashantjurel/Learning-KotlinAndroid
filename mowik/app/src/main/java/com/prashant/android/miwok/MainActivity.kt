package com.prashant.android.miwok

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.prashant.android.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openNumbersList(view: View) {
        val intent = Intent(this,ColorsActivity::class.java)
        startActivity(intent)
    }
}