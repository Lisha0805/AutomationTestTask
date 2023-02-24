package tests.ui

import context.StaticContext
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.openqa.selenium.WebDriver
import webdriver.DriverHolder.driver

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal abstract class UiBaseTest {
    private lateinit var driver: WebDriver

    @BeforeAll
    fun testSetUp() {
        StaticContext.setContext()
        driver = driver()
    }

    @AfterEach
    fun testTearDown() {
        driver.quit()
    }
}