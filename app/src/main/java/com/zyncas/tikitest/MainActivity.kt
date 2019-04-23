package com.zyncas.tikitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mListKeyWord: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpKeywordList()
    }

    private fun setUpKeywordList() {
        mListKeyWord = createKeyWordList()
        val keywordAdapter = KeyWordAdapter(mListKeyWord, this@MainActivity)
        val layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
        rvKeyWord.layoutManager = layoutManager
        rvKeyWord.adapter = keywordAdapter
    }

    private fun createKeyWordList(): List<String> {
        val data = listOf(
            "xiaomi",
            "bitis hunter",
            "bts",
            "balo",
            "bitis hunter x",
            "tai nghe",
            "harry potter",
            "anker",
            "iphone",
            "balo nữ",
            "nguyễn nhật ánh",
            "đắc nhân tâm",
            "ipad",
            "senka",
            "tai nghe bluetooth",
            "son",
            "maybelline",
            "laneige",
            "kem chống nắng",
            "sạc dự phòng",
            "bình giữ nhiệt",
            "anh chính là thanh xuân của em"
        )
        return data
    }
}
