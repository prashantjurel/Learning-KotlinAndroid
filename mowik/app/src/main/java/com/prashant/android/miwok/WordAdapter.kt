package com.prashant.android.miwok

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.prashant.android.R

class WordAdapter(context: Activity, numbersList: ArrayList<Word>) : ArrayAdapter<Word>(context,0,numbersList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val listItemView = convertView ?: run {
            val inflater = LayoutInflater.from(context)
            inflater.inflate(R.layout.list_item, parent, false)!!
        }
            val currentWord: Word = getItem(position)!!
            listItemView.findViewById<TextView?>(R.id.mowik_text_view)?.text = currentWord.miwokText
            listItemView.findViewById<TextView?>(R.id.default_text_view)?.text = currentWord.defaultText
            if(currentWord.hasImage()) {
                listItemView.findViewById<ImageView?>(R.id.mowik_image_view)
                    ?.setImageResource(currentWord.resource)
                listItemView.findViewById<ImageView?>(R.id.mowik_image_view)
                    ?.visibility = VISIBLE
            }
            else
                listItemView.findViewById<ImageView?>(R.id.mowik_image_view)?.visibility = GONE

            return listItemView
        }
}