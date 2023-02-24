package webdriver

import org.openqa.selenium.WebDriver
import webdriver.builder.DriverBuilder

internal object DriverHolder {
    var driver: WebDriver? = null

    fun driver(): WebDriver {
        if (driver == null) {
            driver = DriverBuilder().build()
        }
        return driver as WebDriver
    }
}