package com.appsbg.model.poko.news

data class News(val images: List<Image>,
                val fileName:String,
                val name: String,
                val date_entered: String,
                val description: String,
                val id: String,
                val imageNames:List<String>)