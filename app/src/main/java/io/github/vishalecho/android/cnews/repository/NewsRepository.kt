package io.github.vishalecho.android.cnews.repository

import com.vishalecho.android.core.extension.*
import com.vishalecho.android.core.network.Response
import com.vishalecho.android.core.network.Scheduler
import io.github.vishalecho.android.cnews.data.model.News
import io.github.vishalecho.android.cnews.data.model.NewsDataContract
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject

class NewsRepository(
    private val remote: NewsDataContract.Remote,
    private val scheduler: Scheduler,
    private val compositeDisposable: CompositeDisposable
) : NewsDataContract.Repository {

    override val newsFetchResponse: PublishSubject<Response<List<News>>> =
        PublishSubject.create()

    override fun fetchNews() {
        refreshNews()
    }

    override fun refreshNews() {
        newsFetchResponse.loading(true)
        remote.getNews()
            .performOnBackOutOnMain(scheduler)
            .subscribe({ data ->
                val news: List<News> = data
                newsFetchResponse.success(news)
            }, { error ->
                handleError(error)
            })
            .addTo(compositeDisposable)
    }

    override fun recentNews() {
        newsFetchResponse.loading(true)
        remote.getNews()
            .performOnBackOutOnMain(scheduler)
            .subscribe({ data ->
                val news: List<News> = data.sortedBy { news: News -> news.time_created }
                newsFetchResponse.success(news)
            }, { error ->
                handleError(error)
            })
            .addTo(compositeDisposable)
    }

    override fun popularNews() {
        newsFetchResponse.loading(true)
        remote.getNews()
            .performOnBackOutOnMain(scheduler)
            .subscribe({ data ->
                val news: List<News> = data.sortedBy { news: News -> news.rank }
                newsFetchResponse.success(news)
            }, { error ->
                handleError(error)
            })
            .addTo(compositeDisposable)
    }

    override fun handleError(error: Throwable) {
        newsFetchResponse.failed(error)
    }

}