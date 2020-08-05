package gst.trainingcourse.sampleproject.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import gst.trainingcourse.sampleproject.data.model.RemoteKey

@Dao
interface RemoteKeysDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<RemoteKey>)

    @Query("SELECT * FROM remotekey WHERE id = :id")
    suspend fun getRemoteKeyById(id: String): RemoteKey

    @Query("SELECT * FROM remotekey")
    suspend fun getRemoteKeys(): List<RemoteKey>

    @Query("DELETE FROM remotekey")
    suspend fun clearRemoteKeys()
}