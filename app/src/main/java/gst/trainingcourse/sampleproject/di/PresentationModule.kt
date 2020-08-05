package gst.trainingcourse.sampleproject.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import gst.trainingcourse.sampleproject.ui.main.CatImageDomainToView
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class PresentationModule {

    @Singleton
    @Provides
    fun mapperCatImageDomainToView(): CatImageDomainToView = CatImageDomainToView()
}