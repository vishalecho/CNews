package io.github.vishalecho.android.cnews.repository

import android.os.Build
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.vishalecho.android.core.network.Response
import com.vishalecho.android.core.test.TestScheduler
import io.github.vishalecho.android.cnews.data.DummyNews
import io.github.vishalecho.android.cnews.data.model.News
import io.github.vishalecho.android.cnews.data.model.NewsDataContract
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.io.IOException

/**
 * Tests for [NewsRepository]
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P])
class NewsRepositoryTest {

    private val remote: NewsDataContract.Remote = mock()
    private val compositeDisposable = CompositeDisposable()
    private lateinit var repository: NewsRepository

    @Before
    fun init() {
        repository = NewsRepository(remote, TestScheduler(), compositeDisposable)
        val data = listOf(DummyNews.news)
        whenever(remote.getNews()).doReturn(Single.just(data))
    }

    /**
     * Verify if calling [NewsRepository.fetchNews] triggers [NewsDataContract.Remote.getNews]
     *  and it's result is added to the [NewsRepository.newsFetchResponse]
     * */
    @Test
    fun testFetchNews() {
        val data = listOf(DummyNews.news)
        whenever(remote.getNews()).doReturn(Single.create { data })

        val obs = TestObserver<Response<List<News>>>()

        repository.newsFetchResponse.subscribe(obs)
        obs.assertEmpty()

        repository.fetchNews()
        verify(remote).getNews()

        obs.assertValueAt(0, Response.loading(true))
    }

    /**
     * Verify error refresh of news pushes to [NewsDataContract.Repository.newsFetchResponse]
     * with error
     * */
    @Test
    fun testRefreshNewsFailurePushesToOutcome() {
        val exception = IOException()
        whenever(remote.getNews()).doReturn(Single.error(exception))

        val obs = TestObserver<Response<List<News>>>()
        repository.newsFetchResponse.subscribe(obs)

        repository.refreshNews()

        obs.assertValueAt(0, Response.loading(true))
    }
}