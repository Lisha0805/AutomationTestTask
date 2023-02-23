package api.controller

import api.model.UserData
import api.services.BookStoreService
import http.retrofit.builder.BookStoreRetrofitBuilder

class BookStoreAuthorizationController(
    /*private val bookStoreService: BookStoreService = BookStoreRetrofitBuilder().createService()
        .create(BookStoreService::class.java)*/ // УДАЛИТЬ CREATE!!
    private val bookStoreService: BookStoreService = BookStoreRetrofitBuilder().createService()
        .create(BookStoreService::class.java)
) {

    fun createUser(userData: UserData) {
        bookStoreService
            .createUser(userData)
            .execute()
            .body() ?: error("User isn't created")
    }
}