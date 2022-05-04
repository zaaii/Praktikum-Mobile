package com.zai.job.ui.vacancy

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zai.job.R
import com.zai.job.model.homeData
import com.zai.job.model.vacancyData

class VacancyViewModel : ViewModel() {
    private val _image = MutableLiveData<Int>()
    val image: LiveData<Int> = _image

    fun LoadData(): List<vacancyData>
    {
        return listOf(
            vacancyData(R.drawable.jv1),
            vacancyData(R.drawable.jv2),
            vacancyData(R.drawable.jv3),
            vacancyData(R.drawable.jv4),
            vacancyData(R.drawable.jv5)
        )
    }

    fun setData(data: vacancyData)
    {
        _image.value = data.imageResourceId
    }
}