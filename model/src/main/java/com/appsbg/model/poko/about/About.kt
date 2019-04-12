package com.appsbg.model.poko.about

import com.appsbg.model.poko.BasePalmsBetPoko
import com.squareup.moshi.Json

data class About(
    @Json(name = "name")
    val name: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "id")
    override var id: String
): BasePalmsBetPoko(id)