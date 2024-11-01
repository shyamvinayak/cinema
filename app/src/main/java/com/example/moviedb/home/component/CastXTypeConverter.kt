package com.example.moviedb.home.component

import androidx.room.TypeConverter
import com.example.moviedb.domain.Cast
import com.google.common.reflect.TypeToken
import com.google.gson.Gson

class CastXTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromCastXList(casts: List<Cast>?): String? {
        return gson.toJson(casts)
    }

    @TypeConverter
    fun toCastXList(castsJson: String?): List<Cast>? {
        if (castsJson.isNullOrEmpty()) {
            return null
        }
        val type = object : TypeToken<List<Cast>>() {}.type
        return gson.fromJson(castsJson, type)
    }
}
