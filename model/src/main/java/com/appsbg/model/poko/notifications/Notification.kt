package com.appsbg.model.poko.notifications

import android.os.Parcelable
import com.appsbg.model.poko.BasePalmsBetPoko
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Notification(
    @Json(name = "id")
    var id: String,
    @Json(name = "username")
    val username: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "content")
    val content: String,
    @Json(name = "action")
    val action: String,
    @Json(name = "dateEntered")
    val dateEntered: String
): BasePalmsBetPoko(id), Parcelable
