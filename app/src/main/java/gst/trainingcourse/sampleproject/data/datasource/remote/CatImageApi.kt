package gst.trainingcourse.sampleproject.data.datasource.remote

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface CatImageApi {
    @GET(PATH_CAT_IMAGE)
    suspend fun getCatImage(): CatImageResponse

    @GET(PATH_CAT_IMAGE)
    suspend fun getCatImages(
        @Query(QUERY_PAGE) page: Int,
        @Query(QUERY_PER_PAGE) numberPerPage: Int
    ): List<CatImageResponse>

    companion object {

        fun create(): CatImageApi = buildRetrofit()
            .create(CatImageApi::class.java)

        private fun buildRetrofit() = Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/")
            .client(buildClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        private fun buildClient(): OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(buildInterceptor())
            .addInterceptor(buildLogging())
            .build()

        private fun buildLogging(): Interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        private fun buildInterceptor(): Interceptor = Interceptor { chain ->
            val request = chain.request()
            val newUrl = request.url.newBuilder()
                .build()
            val newRequest = request.newBuilder()
                .url(newUrl)
                .method(request.method, request.body)
                .build()
            chain.proceed(newRequest)
        }
    }
}