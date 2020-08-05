package gst.trainingcourse.sampleproject.data.datasource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import gst.trainingcourse.sampleproject.data.datasource.local.CatImageDatabase.Companion.DATABASE_VERSION
import gst.trainingcourse.sampleproject.data.datasource.local.dao.CatImageDAO
import gst.trainingcourse.sampleproject.data.datasource.local.dao.RemoteKeysDAO
import gst.trainingcourse.sampleproject.data.model.CatImageEntity
import gst.trainingcourse.sampleproject.data.model.RemoteKey

@Database(
    entities = [CatImageEntity::class, RemoteKey::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class CatImageDatabase : RoomDatabase() {
    abstract fun catImageDAO(): CatImageDAO
    abstract fun remoteKeyDAO(): RemoteKeysDAO

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "cat_image_db"
        private var INSTANCE: CatImageDatabase? = null
        fun getInstance(context: Context) = INSTANCE ?: synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(
                context,
                CatImageDatabase::class.java,
                DATABASE_NAME
            ).allowMainThreadQueries().build().also { INSTANCE = it }
        }
    }
}