package com.dag.nexarbmobile.injection

import com.dag.nexarbmobile.session.NexarbSessionManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSessionManager() = NexarbSessionManager()

}