package tests.ui

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import services.booklist.BookListOperations

internal class BookStoreBookListVerificationTest : UiBaseTest() {
    private lateinit var expectedBookTitlesList: List<String>
    private lateinit var actualBookTitlesList: List<String>

    @Test
    fun verifyBookListTest() {
        BookListOperations().apply {
            openBooksPage()
            expectedBookTitlesList = getBookListFromApi()
            actualBookTitlesList = getBookListFromUi()
        }
        Assertions.assertEquals(actualBookTitlesList, expectedBookTitlesList)
    }
}