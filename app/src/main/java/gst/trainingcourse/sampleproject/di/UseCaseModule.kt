package gst.trainingcourse.sampleproject.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import gst.trainingcourse.sampleproject.domain.repository.CatImageRepository
import gst.trainingcourse.sampleproject.domain.usecase.GetCatImagesUseCase
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetCatImagesUseCase(catImageRepository: CatImageRepository): GetCatImagesUseCase = GetCatImagesUseCase(catImageRepository)
}