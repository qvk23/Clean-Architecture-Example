package gst.trainingcourse.sampleproject.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import gst.trainingcourse.sampleproject.data.datasource.remote.CatImageApi
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RemoteModule {
    @Singleton
    @Provides
    fun provideApi(): CatImageApi = CatImageApi.create()
}