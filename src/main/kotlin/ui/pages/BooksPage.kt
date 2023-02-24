package ui.pages

import context.StaticContext.getBaseUrl
import ui.tables.BookStoreTable

internal class BooksPage : BasePage() {
    override val pageUrl: String = "${getBaseUrl()}/books"
    val bookStoreTable: BookStoreTable = BookStoreTable()
}