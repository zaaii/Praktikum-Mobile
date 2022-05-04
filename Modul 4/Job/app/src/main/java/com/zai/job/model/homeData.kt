package com.zai.job.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class homeData (
    @DrawableRes val imageResourceId: Int,
    @StringRes val nameResourceId: Int,
    @StringRes val gajiResourceId: Int,
    @StringRes val descResourceId: Int
)