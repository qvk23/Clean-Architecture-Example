package gst.trainingcourse.sampleproject.domain.repository

import androidx.paging.PagingData
import gst.trainingcourse.sampleproject.domain.model.CatImage
import kotlinx.coroutines.flow.Flow

interface CatImageRepository {
    fun getCatImages(): Flow<PagingData<CatImage>>
}