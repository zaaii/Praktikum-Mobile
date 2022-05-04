package com.zai.job.ui.news

import android.content.Context
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zai.job.R
import com.zai.job.model.homeData
import com.zai.job.model.newsData

class NewsViewModel : ViewModel() {
    private val _image = MutableLiveData<Int>()
    val image: LiveData<Int> = _image

    private val _title = MutableLiveData<String>()
    val title: LiveData<String> = _title

    private val _desc = MutableLiveData<String>()
    val desc: LiveData<String> = _desc

    fun LoadData(): List<newsData>
    {
        return listOf(
            newsData(
                R.drawable.news1,
                R.string.judulN1,
                R.string.isiN1
            ),
            newsData(
                R.drawable.news2,
                R.string.judulN2,
                R.string.isiN2
            ),
            newsData(
                R.drawable.news3,
                R.string.judulN3,
                R.string.isiN3
            ),
            newsData(
                R.drawable.news4,
                R.string.judulN4,
                R.string.isiN4
            )
        )
    }

    fun setData(data: newsData, context: Context)
    {
        _image.value = data.imageResourceId
        _title.value = context.getString(data.titleResourceId)
        _desc.value = context.getString(data.descResourceId)
    }
}