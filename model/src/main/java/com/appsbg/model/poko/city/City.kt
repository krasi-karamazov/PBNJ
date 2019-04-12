package com.appsbg.model.poko.city

import android.os.Parcelable
import com.appsbg.model.poko.BasePalmsBetPoko
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class City(
    @Json(name = "name")
    val name: String,
    @Json(name = "id")
    override var id: String
): BasePalmsBetPoko(id), Parcelable