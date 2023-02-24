package tests.ui

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import services.BookListOperations

class BookStoreBookListVerificationTest : UiBaseTest() {
    private lateinit var actualBookTitlesList: List<String>
    private lateinit var expectedBookTitlesList: List<String>

    @Test
    fun verifyBookListTest() {
        BookListOperations().apply {
            openBooksPage()
            actualBookTitlesList = getBookListFromUi()
            expectedBookTitlesList = getBookListFromApi()
        }
        Assertions.assertEquals(actualBookTitlesList, expectedBookTitlesList)
    }
}