package com.example.rustorecoursepractice.data.local

import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ScreenshotsTypeConverter {

    @TypeConverter
    fun toStringList(list: List<String>): String {
        return Json.encodeToString(list)
    }

    @TypeConverter
    fun fromStringList(list: String): List<String> {
        return Json.decodeFromString(list)
    }
}