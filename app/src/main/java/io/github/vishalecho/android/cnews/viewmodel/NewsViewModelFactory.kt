package io.github.vishalecho.android.cnews.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.vishalecho.android.cnews.data.model.NewsDataContract
import io.reactivex.disposables.CompositeDisposable

class NewsViewModelFactory(
    private val repository: NewsDataContract.Repository,
    private val compositeDisposable: CompositeDisposable
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(repository, compositeDisposable) as T
    }
}