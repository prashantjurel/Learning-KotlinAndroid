package com.prashant.android.miwok

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioFocusRequest
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.prashant.android.R
import java.util.concurrent.TimeUnit


class NumbersFragment : Fragment() {

    private var mediaPlayer: MediaPlayer = MediaPlayer().apply {
        setOnPreparedListener{ start() }
        setOnCompletionListener {
            reset()
            release()
        }
    }
    private lateinit var audioManager: AudioManager
    private lateinit var focusRequest: AudioFocusRequest
    private var handler = Handler()
    private var delayedStopRunnable = Runnable {
        mediaPlayer.stop()
    }


    private val afChangeListener = AudioManager.OnAudioFocusChangeListener { focusChange ->
        when (focusChange) {
            AudioManager.AUDIOFOCUS_LOSS -> {
                // Permanent loss of audio focus
                // Pause playback immediately
                mediaPlayer.release()
                mediaPlayer.reset()
                // Wait 30 seconds before stopping playback
                handler.postDelayed(delayedStopRunnable, TimeUnit.SECONDS.toMillis(30))
            }
            AudioManager.AUDIOFOCUS_LOSS_TRANSIENT, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK -> {
                // Pause playback
                mediaPlayer.pause()
                mediaPlayer.seekTo(0)
            }
            AudioManager.AUDIOFOCUS_GAIN -> {
                // Your app has been granted audio focus again
                // Raise volume to normal, restart playback if necessary
                mediaPlayer.start()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.words_list, container, false)

        audioManager = activity?.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            focusRequest = AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN_TRANSIENT).run {
                setAudioAttributes(AudioAttributes.Builder().run {
                    setUsage(AudioAttributes.USAGE_MEDIA)
                    setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    build()
                })
                setAcceptsDelayedFocusGain(true)
                setOnAudioFocusChangeListener(afChangeListener, handler)
                build()
            }
        } else {
            // Request audio focus for playback
            val result: Int = audioManager.requestAudioFocus(
                afChangeListener,
                // Use the music stream.
                AudioManager.STREAM_MUSIC,
                // Request permanent focus.
                AudioManager.AUDIOFOCUS_GAIN
            )

            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                // Start playback
                mediaPlayer.start()
            }

        }

        val numbersList = arrayListOf<Word>()
        numbersList.add(Word("lutti", "one", R.drawable.number_one, R.raw.number_one))
        numbersList.add(Word("otiiko", "two", R.drawable.number_two, R.raw.number_two))
        numbersList.add(Word("tolookosu", "three", R.drawable.number_three, R.raw.number_three))
        numbersList.add(Word("oyyisa", "four", R.drawable.number_four, R.raw.number_four))
        numbersList.add(Word("massokka", "five", R.drawable.number_five, R.raw.number_five))
        numbersList.add(Word("temmokka", "six", R.drawable.number_six, R.raw.number_six))
        numbersList.add(Word("kenekaku", "seven", R.drawable.number_seven, R.raw.number_seven))
        numbersList.add(Word("kawinta", "eight", R.drawable.number_eight, R.raw.number_eight))
        numbersList.add(Word("wo’e", "nine", R.drawable.number_nine, R.raw.number_nine))
        numbersList.add(Word("na’aacha", "ten", R.drawable.number_ten, R.raw.number_ten))

        val itemAdapter = activity?.let { WordAdapter(it, numbersList, R.color.category_numbers) }

        val listView = rootView.findViewById<ListView>(R.id.list)
        listView.adapter = itemAdapter
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            mediaPlayer.release()
            val focusLock = Any()
            var playbackDelayed = false
            var playbackNowAuthorized = false
            mediaPlayer = MediaPlayer.create(activity, numbersList[position].audio)
            val res = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                audioManager.requestAudioFocus(focusRequest)
            } else {
                audioManager.requestAudioFocus(
                    afChangeListener,
                    // Use the music stream.
                    AudioManager.STREAM_MUSIC,
                    // Request permanent focus.
                    AudioManager.AUDIOFOCUS_GAIN
                )
            }
            synchronized(focusLock) {
                playbackNowAuthorized = when (res) {
                    AudioManager.AUDIOFOCUS_REQUEST_FAILED -> false
                    AudioManager.AUDIOFOCUS_REQUEST_GRANTED -> {
                        mediaPlayer.start()
                        true
                    }
                    AudioManager.AUDIOFOCUS_REQUEST_DELAYED -> {
                        playbackDelayed = true
                        false
                    }
                    else -> false
                }
            }

        }



        return rootView
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer.stop()
        mediaPlayer.reset()
        mediaPlayer.release()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            audioManager.abandonAudioFocusRequest(focusRequest)
        } else {
            audioManager.abandonAudioFocus(afChangeListener)
        }
    }

}