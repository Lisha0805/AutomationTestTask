package webdriver.builder

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import java.time.Duration

internal class DriverBuilder {
    private val defaultPageLoadTimeoutSeconds = 45L
    private val defaultImplicitlyTimeoutSeconds = 45L

    fun build(): WebDriver {
        val driver = WebDriverManager.chromedriver().create()
        configureDriver(driver)
        return driver
    }

    private fun configureDriver(driver: WebDriver) {
        driver.manage().apply {
            window().maximize()
            timeouts().pageLoadTimeout(Duration.ofSeconds(defaultPageLoadTimeoutSeconds))
            timeouts().implicitlyWait(Duration.ofSeconds(defaultImplicitlyTimeoutSeconds))
        }
    }
}