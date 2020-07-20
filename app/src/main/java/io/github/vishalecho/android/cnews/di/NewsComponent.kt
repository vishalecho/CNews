package io.github.vishalecho.android.cnews.di

import com.squareup.picasso.Picasso
import com.vishalecho.android.core.di.component.CoreComponent
import com.vishalecho.android.core.network.Scheduler
import dagger.Component
import dagger.Module
import dagger.Provides
import io.github.vishalecho.android.cnews.data.model.NewsDataContract
import io.github.vishalecho.android.cnews.data.model.NewsRemoteData
import io.github.vishalecho.android.cnews.data.remote.NewsServices
import io.github.vishalecho.android.cnews.repository.NewsRepository
import io.github.vishalecho.android.cnews.ui.NewsActivity
import io.github.vishalecho.android.cnews.ui.NewsAdapter
import io.github.vishalecho.android.cnews.viewmodel.NewsViewModelFactory
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit

@NewsScope
@Component(dependencies = [CoreComponent::class], modules = [NewsModule::class])
interface NewsComponent {
    fun newsServices(): NewsServices
    fun scheduler(): Scheduler
    fun picasso(): Picasso
    fun inject(newsActivity: NewsActivity)
}

@Module
class NewsModule {

    @Provides
    @NewsScope
    fun adapter(picasso: Picasso): NewsAdapter = NewsAdapter(picasso)

    @Provides
    @NewsScope
    fun newsViewModelFactory(
        repository: NewsDataContract.Repository,
        compositeDisposable: CompositeDisposable
    ): NewsViewModelFactory = NewsViewModelFactory(repository, compositeDisposable)

    @Provides
    @NewsScope
    fun newsRepository(
        remote: NewsDataContract.Remote,
        scheduler: Scheduler,
        compositeDisposable: CompositeDisposable
    ): NewsDataContract.Repository = NewsRepository(remote, scheduler, compositeDisposable)

    @Provides
    @NewsScope
    fun remoteData(newsServices: NewsServices): NewsDataContract.Remote =
        NewsRemoteData(newsServices)

    @Provides
    @NewsScope
    fun compositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    @NewsScope
    fun newsServices(retrofit: Retrofit): NewsServices = retrofit.create(NewsServices::class.java)
}