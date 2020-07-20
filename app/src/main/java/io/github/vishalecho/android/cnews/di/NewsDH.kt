package io.github.vishalecho.android.cnews.di

import com.vishalecho.android.core.application.CoreApp
import javax.inject.Singleton

@Singleton
object NewsDH {
    private var newsComponent: NewsComponent? = null

    fun newsComponent(): NewsComponent {
        if (newsComponent == null)
            newsComponent =
                DaggerNewsComponent.builder().coreComponent(CoreApp.coreComponent).build()
        return newsComponent as NewsComponent
    }

    fun destroyNewsComponent() {
        newsComponent = null
    }
}