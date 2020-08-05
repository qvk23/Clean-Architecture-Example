package gst.trainingcourse.sampleproject.ui.main

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import gst.trainingcourse.sampleproject.domain.Mapper
import gst.trainingcourse.sampleproject.domain.model.CatImage
import gst.trainingcourse.sampleproject.domain.usecase.GetCatImagesUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MainViewModel @ViewModelInject constructor(
    private val getCatImagesUseCase: GetCatImagesUseCase
//    private val domainToView: Mapper<PagingData<CatImage>, PagingData<CatImageView>>
) : ViewModel() {
    private val domainToView = CatImageDomainToView()
    fun getCatImages(): Flow<PagingData<CatImageView>> {
        Log.d("MyLogTag", "class: MainViewModel func: getCatImages: (18)")
        val result = getCatImagesUseCase.invoke().cachedIn(viewModelScope)
        return result.map {
            it.run(domainToView)
        }
    }
}