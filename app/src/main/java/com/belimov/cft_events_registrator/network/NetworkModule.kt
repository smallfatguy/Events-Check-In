package com.belimov.cft_events_registrator.network

import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class NetworkModule {

    @Provides
    @Reusable
    fun provideRetrofit(): RetrofitProvider = RetrofitProviderImpl()
}