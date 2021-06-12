package com.prashant.musicplayerdemo

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer:MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this, R.raw.bensound_actionable)
        findViewById<Button>(R.id.play).setOnClickListener{
            mediaPlayer.start()
        }
        findViewById<Button>(R.id.pause).setOnClickListener{
            mediaPlayer.pause()
        }
        findViewById<Button>(R.id.middle).setOnClickListener {
            mediaPlayer.seekTo(mediaPlayer.duration / 2)
        }

    }
}