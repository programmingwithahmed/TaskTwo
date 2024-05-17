package com.abc.tasktwo.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Post(
    val id: Int,
    val title: String,
    val body: String,
    val url: String
): Parcelable
