package ui.tables

import org.openqa.selenium.By
import ui.customelements.Table

class BookStoreTable: Table() {
    override var tableLocator: By = By.className("rt-table")
    override var tableBodyLocator: By = By.className("rt-tbody")
    override val rowLocator: By = By.cssSelector("[role='row']")
    override val columnBodyLocator: By = By.className("rt-td")
    override val particularColumnLocatorString: String = "div[@class='rt-td']"
    override val rowHeaderLocator: By = By.cssSelector("[class='rt-thead -header']")
    override val columnHeaderLocator: By = By.cssSelector("[role='columnheader']")
}