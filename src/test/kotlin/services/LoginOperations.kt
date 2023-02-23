package services

import api.model.UserData
import logger.Logger.info
import org.junit.jupiter.api.Assertions
import org.openqa.selenium.WebElement
import ui.pages.LoginPage
import ui.pages.ProfilePage

class LoginOperations(
    private val loginPage: LoginPage = LoginPage(),
    private val profilePage: ProfilePage = ProfilePage()
) {

    fun loginToBookStore(userData: UserData) {
        info("Input user details for user ${userData.userName}")
        loginPage.apply {
            inputUserName(userData.userName)
            inputPassword(userData.password)
            clickNextButton()
        }
    }

    fun openLoginPage() {
        info("Open login page")
        loginPage.openPage()
    }

    fun verifyProfileHeaderDisplayed() {
        info("Verify profile page is opened")
        val profileMainHeader: WebElement = profilePage.getProfileMainHeader()
        Assertions.assertTrue(profileMainHeader.isDisplayed)
    }
}