package v_builders

import v_builders.data.getProducts
import v_builders.htmlLibrary.*

fun getTitleColor() = "#b9c9fe"
fun getCellColor(row: Int, column: Int) = if ((row + column) %2 == 0) "#dce4ff" else "#eff2ff"

fun renderProductTable(): String {
    return html {
        table {
            tr {
                td {
                    text("Product")
                }
                td {
                    text("Price")
                }
                td {
                    text("Popularity")
                }
            }
            val products = getProducts()
            for((ind, prod) in products.withIndex()) {
                tr {
                    td(color = getCellColor(ind, 0)) {
                        text(prod.description)
                    }
                    td(color = getCellColor(ind, 1)) {
                        text(prod.price)
                    }
                    td(color = getCellColor(ind, 2)) {
                        text(prod.popularity)
                    }
                }
            }
        }
    }.toString()
}
