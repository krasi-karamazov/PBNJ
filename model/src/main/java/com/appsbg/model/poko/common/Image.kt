package com.appsbg.model.poko.common

import android.os.Parcelable
import com.appsbg.model.poko.BasePalmsBetPoko
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(val filename: String,
                 val content_id: String,
                 var id: String,
                 val type: String): BasePalmsBetPoko(id), Parcelable