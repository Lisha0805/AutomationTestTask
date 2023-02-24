package ui.pages

import context.StaticContext.getBaseUrl
import org.openqa.selenium.By

internal class LoginPage : BasePage() {
    override val pageUrl: String = "${getBaseUrl()}/login"
    private val userNameField: By = By.id("userName")
    private val passwordField: By = By.id("password")
    private val nextButton: By = By.id("login")

    fun inputUserName(userName: String) {
        driver.findElement(userNameField).sendKeys(userName)
    }

    fun inputPassword(password: String) {
        driver.findElement(passwordField).sendKeys(password)
    }

    fun clickNextButton() {
        driver.findElement(nextButton).click()
    }
}