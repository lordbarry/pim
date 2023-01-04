package com.barry.newsapp.repository

import com.barry.newsapp.api.retrofit_init
import com.barry.newsapp.db.article_database
import com.barry.newsapp.models.Article

class new_repo(
    val db: article_database
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        retrofit_init.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        retrofit_init.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}