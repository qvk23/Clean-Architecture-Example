package gst.trainingcourse.sampleproject.data.datasource.local

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import gst.trainingcourse.sampleproject.data.datasource.remote.CatImageApi
import gst.trainingcourse.sampleproject.data.datasource.remote.CatImageResponse
import gst.trainingcourse.sampleproject.data.model.CatImageEntity
import gst.trainingcourse.sampleproject.domain.Mapper
import gst.trainingcourse.sampleproject.domain.model.CatImage
import gst.trainingcourse.sampleproject.domain.repository.CatImageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CatImageLocalDataSource @Inject constructor(
    private val catImageApi: CatImageApi,
    private val database: CatImageDatabase,
    private val apiToEntity: Mapper<CatImageResponse, CatImageEntity>,
    private val entityToDomain: Mapper<PagingData<CatImageEntity>, PagingData<CatImage>>
) : CatImageRepository {
    override fun getCatImages(): Flow<PagingData<CatImage>> {
        Log.d("MyLogTag", "class: CatImageLocalDataSource func: getCatImages: (23) ")
        val cat = CatImageRemoteMediator(database, catImageApi, apiToEntity)
        return Pager(
            config = PagingConfig(20),
            remoteMediator = CatImageRemoteMediator(database, catImageApi, apiToEntity)
        ) {
            database.catImageDAO().getCatImages()
        }.flow.map {
            it.run(entityToDomain)
        }
//        return data.map {
//            it.run(entityToDomain)
//        }
    }
}