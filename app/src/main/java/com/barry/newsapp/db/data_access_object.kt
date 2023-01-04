package com.barry.newsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.barry.newsapp.models.Article

// เนี่ย อันนี้ พอผมใช้ kotlin ใหม่ แล้วผมรัน เละ แต่ถ้าเอา suspend ออก ใช้ได้ แต่แอพ crash ผมเลยแนะนำให้ ถ้าจะใช้ฟังก์ชั่น save favourite ก็ login ซะ จะได้เอาขึ้น database บนเนต
@Dao
interface data_access_object {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}