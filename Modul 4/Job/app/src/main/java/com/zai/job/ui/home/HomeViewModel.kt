package com.zai.job.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zai.job.R
import com.zai.job.model.homeData

class HomeViewModel : ViewModel() {
    private val _image = MutableLiveData<Int>()
    val image: LiveData<Int> = _image

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _gaji = MutableLiveData<String>()
    val gaji: LiveData<String> = _gaji

    private val _desc = MutableLiveData<String>()
    val desc: LiveData<String> = _desc

    fun LoadData(): List<homeData>
    {
        return listOf(
            homeData(
                R.drawable.ceo,
                R.string.job1,
                R.string.gaji01,
                R.string.Desc01
            ),
            homeData(
                R.drawable.dgigi,
                R.string.job2,
                R.string.gaji02,
                R.string.Desc02
            ),
            homeData(
                R.drawable.dbedah,
                R.string.job3,
                R.string.gaji03,
                R.string.Desc03
            ),
            homeData(
                R.drawable.pilot,
                R.string.job4,
                R.string.gaji04,
                R.string.Desc04
            ),
            homeData(
                R.drawable.pengacara,
                R.string.job5,
                R.string.gaji05,
                R.string.Desc05
            ),
            homeData(
                R.drawable.salesm,
                R.string.job6,
                R.string.gaji06,
                R.string.Desc06
            ),
            homeData(
                R.drawable.guru,
                R.string.job7,
                R.string.gaji07,
                R.string.Desc07
            ),
            homeData(
                R.drawable.presiden,
                R.string.job8,
                R.string.gaji08,
                R.string.Desc08
            ),
            homeData(
                R.drawable.tentara,
                R.string.job9,
                R.string.gaji09,
                R.string.Desc09
            ),
            homeData(
                R.drawable.programmer,
                R.string.job10,
                R.string.gaji10,
                R.string.Desc10
            )
        )
    }

    fun setData(data: homeData, context: Context)
    {
        _image.value = data.imageResourceId
        _name.value = context.getString(data.nameResourceId)
        _gaji.value = context.getString(data.gajiResourceId)
        _desc.value = context.getString(data.descResourceId)
    }
}