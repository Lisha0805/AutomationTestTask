package ui.pages

import org.openqa.selenium.WebDriver
import webdriver.DriverHolder

internal abstract class BasePage {
    abstract val pageUrl: String
    val driver: WebDriver = DriverHolder.driver()

    fun openPage() {
        driver.get(pageUrl)
    }
}