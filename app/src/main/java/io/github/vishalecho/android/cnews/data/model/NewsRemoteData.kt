package io.github.vishalecho.android.cnews.data.model

import io.github.vishalecho.android.cnews.data.remote.NewsServices
import io.reactivex.Single

class NewsRemoteData(private val newsServices: NewsServices) : NewsDataContract.Remote {
    override fun getNews(): Single<List<News>> {
        return newsServices.getNews()
    }
}