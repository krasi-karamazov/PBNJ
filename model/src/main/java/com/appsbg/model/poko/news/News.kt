package com.appsbg.model.poko.news

import android.os.Parcelable
import com.appsbg.model.poko.BasePalmsBetPoko
import com.appsbg.model.poko.common.Image
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News(val images: List<Image>,
                val fileName:String,
                val name: String,
                val date_entered: String,
                val description: String,
                override var id: String,
                val imageNames:List<String>): BasePalmsBetPoko(id), Parcelable