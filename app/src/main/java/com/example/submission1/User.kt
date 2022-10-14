package com.example.submission1



import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class User(
    var username: String,
    var name: String,
    var repository: String,
    var company: String,
    var following: String,
    var followers: String,
    var avatar: String,
    val resourceId: Int
) : Parcelable

