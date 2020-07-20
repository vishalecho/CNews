package io.github.vishalecho.android.cnews.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.vishalecho.android.core.extension.toLiveData
import com.vishalecho.android.core.network.Response
import io.github.vishalecho.android.cnews.data.model.News
import io.github.vishalecho.android.cnews.data.model.NewsDataContract
import io.github.vishalecho.android.cnews.di.NewsDH
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable

class NewsViewModel(
    private val repository: NewsDataContract.Repository,
    private val compositeDisposable: CompositeDisposable
) : ViewModel() {

    val news: LiveData<Response<List<News>>> by lazy {
        repository.newsFetchResponse.toLiveData(compositeDisposable)
    }

    fun getNews() {
        if (news.value == null) {
            repository.fetchNews()
        }
    }

    fun refreshNews() = repository.refreshNews()

    fun getRecentNews() = repository.recentNews()

    fun getPopularNews() = repository.refreshNews()

    override fun onCleared() {
        super.onCleared()
        //Clear the disposable when the ViewModel is cleared
        compositeDisposable.clear()
        NewsDH.destroyNewsComponent()
    }
}