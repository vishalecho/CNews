package io.github.vishalecho.android.cnews.data.remote

import io.github.vishalecho.android.cnews.data.model.News
import io.reactivex.Single
import retrofit2.http.GET

interface NewsServices {

    @GET("carousell-interview-assets/android/carousell_news.json")
    fun getNews(): Single<List<News>>
}