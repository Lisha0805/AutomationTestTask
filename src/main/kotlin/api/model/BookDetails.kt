package api.model

internal data class BookDetails(
    val isbn: Long,
    val title: String,
    val subTitle: String,
    val author: String,
    val publish_date: String,
    val publisher: String,
    val pages: Int,
    val description: String,
    val website: String
)