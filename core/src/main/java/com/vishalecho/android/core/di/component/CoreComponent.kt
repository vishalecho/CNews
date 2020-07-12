package com.vishalecho.android.core.di.component

import android.content.Context
import android.content.SharedPreferences
import com.vishalecho.android.core.di.module.AppModule
import com.vishalecho.android.core.di.module.NetworkModule
import com.vishalecho.android.core.di.module.StorageModule
import com.vishalecho.android.core.network.Scheduler
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, StorageModule::class])
interface CoreComponent {

    fun context(): Context

    fun retrofit(): Retrofit

    fun scheduler(): Scheduler

    fun sharedPreferences(): SharedPreferences
}