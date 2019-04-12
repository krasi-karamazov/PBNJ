package com.appsbg.model.poko.casinos

import android.os.Parcelable
import com.appsbg.model.poko.BasePalmsBetPoko
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Promo(
    @Json(name = "casino_id")
    val casinoId: String,
    @Json(name = "casino_name")
    val casinoName: String,
    @Json(name = "end_time")
    val endTime: String,
    @Json(name = "id")
    override var id: String,
    @Json(name = "month_date")
    val monthDate: String,
    @Json(name = "month_day")
    val monthDay: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "start_day")
    val startDay: String,
    @Json(name = "start_time")
    val startTime: String,
    @Json(name = "type")
    val type: String
): BasePalmsBetPoko(id), Parcelable