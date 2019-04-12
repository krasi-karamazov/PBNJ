package com.appsbg.model.poko

import com.appsbg.model.poko.about.About
import com.appsbg.model.poko.casinos.Casino
import com.appsbg.model.poko.city.City
import com.appsbg.model.poko.news.News
import com.appsbg.model.poko.terms.Terms

class PalmsbetDataWrapper{
    private var api: String? = null

    private var news: List<News>? = null

    private var cities: Array<City>? = null

    private var terms: Terms? = null

    private var about: About? = null

    private var casinos: List<Casino>? = null
}