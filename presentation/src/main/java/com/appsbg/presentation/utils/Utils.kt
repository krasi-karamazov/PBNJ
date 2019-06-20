package com.appsbg.presentation.utils

import android.content.Context
import com.appsbg.presentation.R
import java.util.*

class Utils {

    companion object {
        fun imageUrlThumb(filename: String): String {
            return "https://palmsbet.apps.bg/images/" + filename.replace("\\", "") + "_th.jpg"
        }

        fun imageUrl(filename: String): String {
            return "https://palmsbet.apps.bg/images/" + filename.replace("\\", "") + ".jpg"
        }

        fun getDayName(context: Context, day: Int): String {
            when (day) {
                Calendar.MONDAY -> return context.resources.getString(R.string.mon)
                Calendar.TUESDAY -> return context.resources.getString(R.string.tue)
                Calendar.WEDNESDAY -> return context.resources.getString(R.string.wen)
                Calendar.THURSDAY -> return context.resources.getString(R.string.thu)
                Calendar.FRIDAY -> return context.resources.getString(R.string.fri)
                Calendar.SATURDAY -> return context.resources.getString(R.string.sat)
                else -> return context.resources.getString(R.string.sun)
            }
        }

        fun getMonthName(context: Context, month: Int): String {
            when (month) {
                1 -> return "ЯНУАРИ"
                2 -> return "ФЕВРУАРИ"
                3 -> return "МАРТ"
                4 -> return "АПРИЛ"
                5 -> return "МАЙ"
                6 -> return "ЮНИ"
                7 -> return "ЮЛИ"
                8 -> return "АВГУСТ"
                9 -> return "СЕПТЕМВРИ"
                10 -> return "ОКТОМВРИ"
                11 -> return "НОЕМВРИ"
                else -> return "ДЕКЕМВРИ"
            }
        }
    }
}