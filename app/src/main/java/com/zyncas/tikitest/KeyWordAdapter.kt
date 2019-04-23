package com.zyncas.tikitest

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class KeyWordAdapter(val listKeyWord: List<String>, val activity: Activity) :
    RecyclerView.Adapter<KeyWordAdapter.KeyWordViewHolder>() {
    private val TAG by lazy {
        KeyWordAdapter::class.java.simpleName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeyWordViewHolder {
        val itemView: View = activity.layoutInflater.inflate(R.layout.item_keyword, parent, false)
        return KeyWordViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listKeyWord.size
    }

    override fun onBindViewHolder(holder: KeyWordViewHolder, position: Int) {
        val keyword = listKeyWord[position]
        holder.mTvKeyWord.text = separateKeyword(keyword.trim())
        val randomNumber = (0..10).random()
        holder.mTvKeyWord.setBackgroundColor(ContextCompat.getColor(activity, generateRandomBackground(randomNumber)))
    }

    /**
     * Create a random background
     */
    private fun generateRandomBackground(number: Int): Int {
        when (number) {
            1 -> {
                return R.color.color_utility_service
            }
            2 -> {
                return R.color.color_green_bold
            }
            3 -> {
                return R.color.color_yellow_bold
            }
            4 -> {
                return R.color.color_purple_bold
            }
            5 -> {
                return R.color.color_blue_bold
            }
            else -> {
                return R.color.color_red_bold
            }
        }
    }

    /**
     * get a keyword after separate
     */
    private fun separateKeyword(keyword: String): String {
        val numberOfText = keyword.split(" ")
        var length = 0
        var pivot = 0
        if (numberOfText.size > 1) {
            pivot = 0
            for (i in 0..numberOfText.size / 2 + 1) {
                if (length < calculateLengthRest(i + 1, numberOfText)) {
                    length += numberOfText.get(i).length
                    pivot = i
                }
            }
            return consumeText(pivot, numberOfText)
        }
        return keyword
    }

    /**
     * consume a text after separate
     */
    private fun consumeText(pivot: Int, data: List<String>): String {
        var result = ""
        for (i in 0 until data.size) {
            result += data[i] + " "
            if (i == pivot) {
                result += "\n"
            }
        }
        return result
    }

    /**
     * Get a length of rest text
     */
    private fun calculateLengthRest(startPivot: Int, data: List<String>): Int {
        var lengthSum = 0
        for (i in startPivot until data.size) {
            lengthSum += data[i].length
        }
        return lengthSum
    }

    class KeyWordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mTvKeyWord: TextView = itemView.findViewById(R.id.tv_keyword)
    }
}