package com.prashant.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.prashant.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: Name = Name("WhiteRose")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.name = myName
        binding.button.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View) {

        binding.apply {
            myName?.nickname = binding.nickNameEdit.text.toString()
            invalidateAll()
            binding.nickNameEdit.visibility = View.GONE
            binding.button.visibility = View.GONE
            binding.nickNameText.visibility = View.VISIBLE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}