package gst.trainingcourse.sampleproject.data.datasource.mapper

import gst.trainingcourse.sampleproject.data.datasource.remote.CatImageResponse
import gst.trainingcourse.sampleproject.data.model.CatImageEntity
import gst.trainingcourse.sampleproject.domain.Mapper

class CatImageResponseToCatImageEntity : Mapper<CatImageResponse, CatImageEntity> {
    override fun invoke(input: CatImageResponse): CatImageEntity {
        return CatImageEntity(
            id = input.id,
            url = input.url
        )
    }
}