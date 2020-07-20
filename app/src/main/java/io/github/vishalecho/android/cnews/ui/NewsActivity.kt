package io.github.vishalecho.android.cnews.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.vishalecho.android.core.network.Response
import com.vishalecho.android.core.ui.base.BaseActivity
import io.github.vishalecho.android.cnews.R
import io.github.vishalecho.android.cnews.data.model.News
import io.github.vishalecho.android.cnews.databinding.ActivityNewsBinding
import io.github.vishalecho.android.cnews.di.NewsDH
import io.github.vishalecho.android.cnews.viewmodel.NewsViewModel
import io.github.vishalecho.android.cnews.viewmodel.NewsViewModelFactory
import kotlinx.android.synthetic.main.activity_news.*
import java.io.IOException
import javax.inject.Inject

class NewsActivity : BaseActivity(), NewsAdapter.Interaction {

    private lateinit var binding: ActivityNewsBinding
    private val component by lazy { NewsDH.newsComponent() }

    @Inject
    lateinit var viewModelFactory: NewsViewModelFactory

    @Inject
    lateinit var adapter: NewsAdapter

    private val viewModel: NewsViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(NewsViewModel::class.java)
    }

    private val context: Context by lazy { this }

    private val tag = NewsActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setUpToolbar()
        setContentView(binding.root)

        component.inject(this)
        adapter.interaction = this
        rvNews.adapter = adapter
        srlNews.setOnRefreshListener { viewModel.refreshNews() }

        viewModel.getNews()
        initiateDataListener()
    }

    private fun initiateDataListener() {
        //Observe the response and update state of the screen accordingly
        viewModel.news.observe(this, Observer { response ->
            Log.d(tag, "initiateDataListener: $response")
            when (response) {
                is Response.Progress -> srlNews.isRefreshing = response.loading

                is Response.Success  -> {
                    Log.d(tag, "initiateDataListener: Successfully loaded data")
                    adapter.swapData(response.data)
                }

                is Response.Failure  -> {
                    if (response.e is IOException)
                        Toast.makeText(context, R.string.no_internet, Toast.LENGTH_LONG).show()
                    else
                        Toast.makeText(context, R.string.failed_try_again, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun setUpToolbar() {
        binding.topAppbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.recent -> {
                    // Handle recent menu item press
                    recentNews()
                    true
                }
                R.id.popular -> {
                    // Handle popular menu item press
                    popularNews()
                    true
                }
                else -> false
            } as Boolean
        }
    }

    private fun recentNews() {
        viewModel.getRecentNews()
    }

    private fun popularNews() {
        viewModel.getPopularNews()
    }

    override fun newsClicked(position: Int, news: News) {
        //Empty method
    }
}