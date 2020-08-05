package gst.trainingcourse.sampleproject.data.datasource.local

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import gst.trainingcourse.sampleproject.data.datasource.remote.CatImageApi
import gst.trainingcourse.sampleproject.data.datasource.remote.CatImageResponse
import gst.trainingcourse.sampleproject.data.model.CatImageEntity
import gst.trainingcourse.sampleproject.data.model.RemoteKey
import gst.trainingcourse.sampleproject.domain.Mapper
import java.io.IOException
import java.io.InvalidObjectException
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class CatImageRemoteMediator @Inject constructor(
    private val database: CatImageDatabase,
    private val catImageApi: CatImageApi,
    private val apiToEntity: Mapper<CatImageResponse, CatImageEntity>
) : RemoteMediator<Int, CatImageEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CatImageEntity>
    ): MediatorResult {
        Log.d("MyLogTag", "class: CatImageRemoteMediator func: load: (22) $loadType")
        val page = when (loadType) {
            LoadType.REFRESH -> {
                val remoteKey = getRemoteKeyClosetToCurrentPosition(state)
                remoteKey?.nextKey?.minus(1) ?: 1
            }
            LoadType.PREPEND -> {
                return MediatorResult.Success(true)
            }
            LoadType.APPEND -> {
                val remoteKey = getRemoteKeyForLastItem(state)
                if (remoteKey?.nextKey == null) {
                    throw InvalidObjectException("Remote key should not be null for $loadType")
                }
                remoteKey.nextKey
            }
        }
        Log.d("MyLogTag", "class: CatImageRemoteMediator func: load: (40) $page")
        try {
            val data = catImageApi.getCatImages(page, state.config.pageSize).map(apiToEntity)
            val endOfPaginationReached = data.isEmpty()
            database.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    with(database) {
                        remoteKeyDAO().clearRemoteKeys()
                        catImageDAO().clearCatImages()
                    }
                }
                val prevKey = if (page == 1) null else page - 1
                val nextKey = if (endOfPaginationReached) null else page + 1
                val keys = data.map {
                    RemoteKey(id = it.id, prevKey = prevKey, nextKey = nextKey)
                }
                Log.d("MyLogTag", "class: CatImageRemoteMediator func: load: (61) $keys")
                database.remoteKeyDAO().insertAll(keys)
                database.catImageDAO().insertAll(data)
            }
            return MediatorResult.Success(endOfPaginationReached = true)
        } catch (e: IOException) {
            return MediatorResult.Error(e)
        }
    }

    private suspend fun getRemoteKeyClosetToCurrentPosition(state: PagingState<Int, CatImageEntity>): RemoteKey? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let {
                database.remoteKeyDAO().getRemoteKeyById(it)
            }
        }.also {
            Log.d(
                "MyLogTag",
                "class: CatImageRemoteMediator func: getRemoteKeyClosetToCurrentPosition: (65) $it"
            )
        }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, CatImageEntity>): RemoteKey? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()?.let {
            database.remoteKeyDAO().getRemoteKeyById(it.id)
        }.also {
            Log.d(
                "MyLogTag",
                "class: CatImageRemoteMediator func: getRemoteKeyForLastItem: (76) $it"
            )
        }
    }
}