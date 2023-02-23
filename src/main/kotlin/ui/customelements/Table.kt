package ui.customelements

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import webdriver.DriverHolder.driver

abstract class Table {
    abstract var tableLocator: By
    abstract var tableBodyLocator: By
    abstract val rowLocator: By
    abstract val columnBodyLocator: By
    abstract val particularColumnLocatorString: String
    abstract val rowHeaderLocator: By
    abstract val columnHeaderLocator: By

    fun getColumnContent(columnName: String): List<String> {
        val columnIndex = getColumnIndexByName(columnName)
        return getParticularColumnContent(columnIndex)
    }

    private fun getColumnLocator(columnIndex: Int): By {
        return By.xpath("${particularColumnLocatorString}[${columnIndex}]")
    }

    private fun getColumnIndexByName(columnName: String): Int {
        val tableHeaderRows: WebElement = driver().findElement(rowHeaderLocator)
        val tableHeaderColumns: List<WebElement> = tableHeaderRows.findElements(columnHeaderLocator)
        val listHeaderColumns: List<String> = tableHeaderColumns.map { it.text }
        return listHeaderColumns.indexOf(columnName).plus(1)
    }

    private fun getParticularColumnContent(columnIndex: Int): List<String> {
        val tableBody = driver().findElement(tableBodyLocator)
        val bodyRows = tableBody.findElements(rowLocator)
        val columnValues = mutableListOf<String>()
        val columnLocator = getColumnLocator(columnIndex)
        bodyRows.forEach {
            val columnValue = it.findElement(columnLocator)
            if (columnValue.text.isNotBlank()) {
                columnValues.add(columnValue.text)
            }
        }
        return columnValues
    }
}