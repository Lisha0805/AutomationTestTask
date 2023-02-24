package api.controller

import api.model.*
import http.retrofit.builder.BookStoreRetrofitBuilder
import api.services.BookStoreService

internal class BookStoreBookListController(
    private val bookStoreService: BookStoreService = BookStoreRetrofitBuilder().createService(BookStoreService::class.java)
) {

    fun getBookList(): GetBookListResponse {
        return bookStoreService
            .getBookList()
            .execute()
            .body() ?: error("Book list isn't returned")
    }
}