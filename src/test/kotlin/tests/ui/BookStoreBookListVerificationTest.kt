package tests.ui

import api.controller.BookStoreBookListController
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ui.tables.BookStoreTable

class BookStoreBookListVerificationTest: UiBaseTest() {

    /*@BeforeEach
    fun open(){
        driver().get("https://demoqa.com/books")
    }*/

    @Test
    fun verifyBookListTest() {
        val expectedBookList = BookStoreBookListController().getBookList().books
        val expectedBookTitlesList = expectedBookList.map {
            it.title
        }
        val actualBookTitlesList = BookStoreTable().getColumnContent("Title")
        Assertions.assertEquals(actualBookTitlesList, expectedBookTitlesList)
    }

    //создать класс operations: методы для создания листов
    //operations
// apply
// {
// list1
//    list2
// }
    // assert

    // метод beforeEach -> openPage закинуть в operations
}