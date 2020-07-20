package io.github.vishalecho.android.cnews.data.remote

import android.os.Build
import com.vishalecho.android.core.test.DependencyProvider
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.io.IOException

/**
 * Test for [NewsServices] class
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P])
class NewsServicesTest {

    private lateinit var newsServices: NewsServices
    private lateinit var mockWebServer: MockWebServer

    @Before
    fun init() {
        mockWebServer = MockWebServer()
        newsServices =
            DependencyProvider.getRetrofit(mockWebServer.url("/")).create(NewsServices::class.java)
    }

    @After
    @Throws(IOException::class)
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun getNews() {
        queueResponse {
            setResponseCode(200)
            setBody(DependencyProvider.getResponseFromJson("carousell_news"))
        }

        newsServices.getNews()
            .test()
            .run {
                assertNoErrors()
                assertValueCount(1)
                Assert.assertEquals(valueCount(), 1)
                Assert.assertEquals(values()[0][0].id, "121")
                Assert.assertEquals(values()[0][0].rank, 2)
                Assert.assertEquals(values()[0][0].time_created, 1532853058)
            }
    }

    private fun queueResponse(block: MockResponse.() -> Unit) {
        mockWebServer.enqueue(MockResponse().apply(block))
    }
}