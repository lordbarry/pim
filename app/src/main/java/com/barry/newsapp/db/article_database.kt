package com.barry.newsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.barry.newsapp.models.Article

//พวกนี้เป็น init local database ล้วน ๆ เลย
@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(convertor::class)
abstract class article_database : RoomDatabase() {

    abstract fun getArticleDao(): data_access_object

    companion object {
        @Volatile
        private var instance: article_database? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                article_database::class.java,
                "article_db.db"
            ).build()
    }
}