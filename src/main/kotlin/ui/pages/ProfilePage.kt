package ui.pages

import context.StaticContext.getBaseUrl
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import webdriver.DriverHolder.driver

class ProfilePage: BasePage() {
    override val pageUrl: String = "${getBaseUrl()}/profile"
    private val profileMainHeader: By = By.xpath("//div[text()='Profile'][@class='main-header']")

    fun getProfileMainHeader(): WebElement{
        return driver().findElement(profileMainHeader)
    }
}