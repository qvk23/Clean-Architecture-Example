package gst.trainingcourse.sampleproject.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import gst.trainingcourse.sampleproject.data.datasource.local.CatImageDatabase
import gst.trainingcourse.sampleproject.data.datasource.local.CatImageLocalDataSource
import gst.trainingcourse.sampleproject.data.datasource.local.CatImageRemoteMediator
import gst.trainingcourse.sampleproject.data.datasource.mapper.CatImageEntityToDomain
import gst.trainingcourse.sampleproject.data.datasource.mapper.CatImageResponseToCatImageEntity
import gst.trainingcourse.sampleproject.data.datasource.remote.CatImageApi
import gst.trainingcourse.sampleproject.data.repository.CatImageRepositoryImp
import gst.trainingcourse.sampleproject.domain.repository.CatImageRepository
import javax.inject.Singleton

@Module(includes = [DatabaseModule::class, RemoteModule::class])
@InstallIn(ApplicationComponent::class)
class DataModule {
    @Singleton
    @Provides
    fun mapperCatImageEntityToDomain(): CatImageEntityToDomain = CatImageEntityToDomain()

    @Singleton
    @Provides
    fun mapperCatImageResponseToEntity(): CatImageResponseToCatImageEntity =
        CatImageResponseToCatImageEntity()

    @Singleton
    @Provides
    fun provideRemoteMediator(
        database: CatImageDatabase,
        api: CatImageApi,
        apiToEntity: CatImageResponseToCatImageEntity
    ) = CatImageRemoteMediator(database, api, apiToEntity)

    @Provides
    fun provideLocalDataSource(
        api: CatImageApi,
        database: CatImageDatabase,
        apiToEntity: CatImageResponseToCatImageEntity,
        entityToDomain: CatImageEntityToDomain
    ): CatImageLocalDataSource = CatImageLocalDataSource(api, database, apiToEntity, entityToDomain)

    @Provides
    fun provideRepository(localDataSource: CatImageLocalDataSource): CatImageRepository =
        CatImageRepositoryImp(localDataSource)
}