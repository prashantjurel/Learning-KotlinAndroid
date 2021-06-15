package com.prashant.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener{
            addNickName(it)
        }
    }

    private fun addNickName(view: View) {
            var nickName = findViewById<TextView>(R.id.nick_name_text)
            var nickNameEdit = findViewById<EditText>(R.id.nick_name_edit)
            nickName.text = nickNameEdit.text
            nickNameEdit.visibility = View.GONE
            view.visibility = View.GONE
            nickName.visibility = View.VISIBLE

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}