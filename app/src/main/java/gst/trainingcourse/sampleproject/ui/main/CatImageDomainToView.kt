package gst.trainingcourse.sampleproject.ui.main

import androidx.paging.PagingData
import androidx.paging.map
import gst.trainingcourse.sampleproject.domain.Mapper
import gst.trainingcourse.sampleproject.domain.model.CatImage


class CatImageDomainToView : Mapper<PagingData<CatImage>, PagingData<CatImageView>> {
    override fun invoke(paging: PagingData<CatImage>): PagingData<CatImageView> {
        return paging.map {
            CatImageView(id = it.id, url = it.url)
        }
    }
}