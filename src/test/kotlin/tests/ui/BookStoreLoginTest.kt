package tests.ui

import api.controller.BookStoreAuthorizationController
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import services.login.LoginOperations
import api.model.UserData
import services.userdata.UserDataProvider.getUserData

internal class BookStoreLoginTest : UiBaseTest() {
    private lateinit var expectedUser: UserData

    @BeforeEach
    fun createExpectedUser() {
        expectedUser = getUserData()
        BookStoreAuthorizationController().createUser(expectedUser)
    }

    @Test
    fun loginToTheBookStoreTest() {
        LoginOperations().apply {
            openLoginPage()
            loginToBookStore(expectedUser)
            verifyProfileHeaderDisplayed()
        }
    }
}