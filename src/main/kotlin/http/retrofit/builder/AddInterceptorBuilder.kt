package http.retrofit.builder

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

internal class AddInterceptorBuilder {
    private val defaultInterceptorList: List<Interceptor> = listOf(addLoggingInterceptors())

    private fun addLoggingInterceptors(): Interceptor {
        return HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }

    fun addDefaultInterceptors(client: OkHttpClient.Builder): OkHttpClient.Builder {
        defaultInterceptorList.forEach { interceptor ->
            client.addInterceptor(interceptor)
        }
        return client
    }
}