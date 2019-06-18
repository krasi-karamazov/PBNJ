package com.appsbg.model.poko.casinos

import android.os.Parcelable
import com.appsbg.model.poko.BasePalmsBetPoko
import com.appsbg.model.poko.common.Image
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Casino(
    @Json(name = "address")
    val address: String,
    @Json(name = "city_id")
    val cityId: String,
    @Json(name = "city_name")
    val cityName: String,
    @Json(name = "cms_id")
    val cmsId: String,
    @Json(name = "contact_name")
    val contactName: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "email")
    val email: String,
    @Json(name = "filename")
    val filename: String,
    @Json(name = "group_id")
    val groupId: String,
    @Json(name = "id")
    var id: String,
    @Json(name = "images")
    val images: List<Image>,
    @Json(name = "jackpot_bronze")
    val jackpotBronze: String,
    @Json(name = "jackpot_gold")
    val jackpotGold: String,
    @Json(name = "jackpot_silver")
    val jackpotSilver: String,
    @Json(name = "lat")
    val lat: Double,
    @Json(name = "lng")
    val lng: Double,
    @Json(name = "name")
    val name: String,
    @Json(name = "phone")
    val phone: String,
    @Json(name = "promo")
    val promo: List<Promo>,
    @Json(name = "promo_month")
    val promoMonth: Promo,
    @Json(name = "wikimapia_url")
    val wikimapiaUrl: String
): BasePalmsBetPoko(id), Parcelable