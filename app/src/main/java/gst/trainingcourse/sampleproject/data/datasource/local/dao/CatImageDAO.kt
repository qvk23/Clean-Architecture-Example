package gst.trainingcourse.sampleproject.data.datasource.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import gst.trainingcourse.sampleproject.data.model.CatImageEntity

@Dao
interface CatImageDAO {
    @Query("SELECT * FROM tb_cat_image")
    fun getCatImages(): PagingSource<Int, CatImageEntity>

    @Insert
    fun insertAll(catImage: List<CatImageEntity>)

    @Query("DELETE FROM tb_cat_image")
    suspend fun clearCatImages()
}