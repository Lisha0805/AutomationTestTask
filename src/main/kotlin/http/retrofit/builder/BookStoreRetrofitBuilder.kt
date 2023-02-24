package http.retrofit.builder

import context.StaticContext.getBaseUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal class BookStoreRetrofitBuilder {
    private val interceptorBuilder: AddInterceptorBuilder = AddInterceptorBuilder()

    private fun createHttpClient(): OkHttpClient.Builder {
        return OkHttpClient.Builder().run {
            interceptorBuilder.addDefaultInterceptors(this)
        }
    }

    fun <T> createService(service: Class<T>): T {
        val httpClient = createHttpClient()
        return Retrofit.Builder()
            .baseUrl(getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
            .create(service)
    }
}