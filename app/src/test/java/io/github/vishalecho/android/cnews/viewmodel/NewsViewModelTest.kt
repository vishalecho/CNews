package io.github.vishalecho.android.cnews.viewmodel

import android.os.Build
import androidx.lifecycle.Observer
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.vishalecho.android.core.network.Response
import io.github.vishalecho.android.cnews.data.DummyNews
import io.github.vishalecho.android.cnews.data.model.News
import io.github.vishalecho.android.cnews.data.model.NewsDataContract
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.io.IOException


/**
 * Test for [NewsViewModel] class
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P])
class NewsViewModelTest {

    private lateinit var viewModel: NewsViewModel

    private val repo: NewsDataContract.Repository = mock()

    private val response: Observer<Response<List<News>>> = mock()

    @Before
    fun init() {
        viewModel = NewsViewModel(repo, CompositeDisposable())
        whenever(repo.newsFetchResponse).doReturn(PublishSubject.create())
        viewModel.news.observeForever(response)
    }

    /**
     * Test [NewsViewModel.getNews] triggers [NewsDataContract.Repository.fetchNews] &
     * liveData [NewsViewModel.news] gets responses pushed
     * from [NewsDataContract.Repository.newsFetchResponse]
     * */
    @Test
    fun testGetNewsSuccess() {
        viewModel.getNews()
        verify(repo).fetchNews()

        repo.newsFetchResponse.onNext(Response.loading(true))
        verify(response).onChanged(Response.loading(true))

        repo.newsFetchResponse.onNext(Response.loading(false))
        verify(response).onChanged(Response.loading(false))

        val data = listOf(DummyNews.news)
        repo.newsFetchResponse.onNext(Response.success(data))
        verify(response).onChanged(Response.success(data))
    }

    /**
     * Test that [NewsDataContract.Repository.newsFetchResponse] on exception passes exception to
     * live [NewsViewModel.news]
     * */
    @Test
    fun testGetNewsError() {
        val exception = IOException()
        repo.newsFetchResponse.onNext(Response.failure(exception))
        verify(response).onChanged(Response.failure(exception))
    }

    /**
     * Verify [NewsViewModel.refreshNews] triggers [NewsDataContract.Repository.refreshNews]
     * */
    @Test
    fun testRefreshRestaurants() {
        viewModel.refreshNews()
        verify(repo).refreshNews()
    }

}