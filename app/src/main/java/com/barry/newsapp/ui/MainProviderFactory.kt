package com.barry.newsapp.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.barry.newsapp.repository.new_repo

class MainProviderFactory(
    val app: Application,
    val newrepo: new_repo
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(app, newrepo) as T
    }
}