package gst.trainingcourse.sampleproject.domain.usecase

import gst.trainingcourse.sampleproject.domain.repository.CatImageRepository
import javax.inject.Inject

class GetCatImagesUseCase @Inject constructor(private val catImageRepository: CatImageRepository) {
    operator fun invoke() = catImageRepository.getCatImages()
}