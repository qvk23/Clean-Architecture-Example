package gst.trainingcourse.sampleproject.data.repository

import android.util.Log
import androidx.paging.PagingData
import gst.trainingcourse.sampleproject.data.datasource.local.CatImageLocalDataSource
import gst.trainingcourse.sampleproject.domain.model.CatImage
import gst.trainingcourse.sampleproject.domain.repository.CatImageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CatImageRepositoryImp @Inject constructor(
    private val localDataSource: CatImageLocalDataSource
) : CatImageRepository {
    override fun getCatImages(): Flow<PagingData<CatImage>> {
        Log.d("MyLogTag", "class: CatImageRepositoryImp func: getCatImages: (14) ")
        return localDataSource.getCatImages()
    }
}