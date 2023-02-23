package api.services

import api.model.*
import api.model.UserData
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface BookStoreService {

    @GET("/BookStore/v1/Books")
    fun getBookList(
    ): Call<GetBookListResponse>

    @POST("/Account/v1/User")
    fun createUser(
        @Body body: UserData
    ): Call<ResponseBody>
}