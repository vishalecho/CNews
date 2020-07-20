package io.github.vishalecho.android.cnews.data.model

import com.vishalecho.android.core.network.Response
import io.reactivex.Single
import io.reactivex.subjects.PublishSubject

interface NewsDataContract {

    interface Repository {
        val newsFetchResponse: PublishSubject<Response<List<News>>>
        fun fetchNews()
        fun refreshNews()
        fun recentNews()
        fun popularNews()
        fun handleError(error: Throwable)
    }

    interface Remote {
        fun getNews(): Single<List<News>>
    }
}