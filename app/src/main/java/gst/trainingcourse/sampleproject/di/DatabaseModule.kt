package gst.trainingcourse.sampleproject.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import gst.trainingcourse.sampleproject.data.datasource.local.CatImageDatabase
import gst.trainingcourse.sampleproject.data.datasource.local.dao.CatImageDAO
import gst.trainingcourse.sampleproject.data.datasource.local.dao.RemoteKeysDAO
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(application: Application): CatImageDatabase = CatImageDatabase.getInstance(application)

    @Provides
    @Singleton
    fun provideCatImageDao(catImageDatabase: CatImageDatabase): CatImageDAO = catImageDatabase.catImageDAO()

    @Provides
    @Singleton
    fun provideRemoteKeyDao(catImageDatabase: CatImageDatabase): RemoteKeysDAO = catImageDatabase.remoteKeyDAO()
}
