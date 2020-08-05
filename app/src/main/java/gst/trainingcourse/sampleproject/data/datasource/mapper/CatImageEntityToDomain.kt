package gst.trainingcourse.sampleproject.data.datasource.mapper

import androidx.paging.PagingData
import androidx.paging.map
import gst.trainingcourse.sampleproject.data.model.CatImageEntity
import gst.trainingcourse.sampleproject.domain.Mapper
import gst.trainingcourse.sampleproject.domain.model.CatImage

class CatImageEntityToDomain : Mapper<PagingData<CatImageEntity>, PagingData<CatImage>> {
    override fun invoke(paging: PagingData<CatImageEntity>): PagingData<CatImage> {
        return paging.map {
            CatImage(id = it.id, url = it.url)
        }
    }
}