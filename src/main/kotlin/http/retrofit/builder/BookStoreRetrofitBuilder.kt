package http.retrofit.builder

import context.StaticContext.getBaseUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BookStoreRetrofitBuilder {
    private val interceptorBuilder: AddInterceptorBuilder = AddInterceptorBuilder()

    private fun createHttpClient(): OkHttpClient.Builder {
        return OkHttpClient.Builder().run {
            interceptorBuilder.addDefaultInterceptors(this)
        }
    }

    fun createService(): Retrofit {
        val httpClient = createHttpClient()
        return Retrofit.Builder()
            .baseUrl(getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
    }
}