package gst.trainingcourse.sampleproject.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = CatImageEntry.TABLE_NAME)
data class CatImageEntity(
    @PrimaryKey
    val id: String,
    val url: String
)
object CatImageEntry {
    const val TABLE_NAME = "tb_cat_image"
}