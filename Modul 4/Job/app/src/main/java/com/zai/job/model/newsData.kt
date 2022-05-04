package com.zai.job.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class newsData (
    @DrawableRes val imageResourceId: Int,
    @StringRes val titleResourceId: Int,
    @StringRes val descResourceId: Int,
    )