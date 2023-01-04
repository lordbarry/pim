package com.barry.newsapp.db

import androidx.room.TypeConverter
import com.barry.newsapp.models.Source

// อันนี้คือแปลงค่าจาก api ให่เป็น key แบบ kotlin
class convertor {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}