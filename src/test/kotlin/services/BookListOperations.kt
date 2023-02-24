package services

import api.controller.BookStoreBookListController
import logger.Logger.info
import ui.pages.BooksPage

class BookListOperations(
    private val booksPage: BooksPage = BooksPage()
) {
    private val columnName = "Title"
    fun openBooksPage() {
        info("Open book page")
        booksPage.openPage()
    }

    fun getBookListFromApi(): List<String> {
        info("Get book list from api request")
        return BookStoreBookListController().getBookList().books.map {
            it.title
        }
    }

    fun getBookListFromUi(): List<String> {
        info("Get book list from ui by column name")
        return booksPage.bookStoreTable.getColumnContent(columnName)
    }
}