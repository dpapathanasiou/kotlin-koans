package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    // Return the set of customers who ordered the specified product
    return this.customers.filter {
        it.orders.any { it.products.contains(product) }
    }.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)
    return this?.orders.filter { it.isDelivered }.flatMap { it.products }.maxBy { it.price }
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.

    // close, but fails last test (one customer orders same product multiple times)
    //return this?.customers.flatMap { it.orders.filter { it.products.contains(product) } }.count()
    
    return this.customers.flatMap {
        val orderedProducts = it.orders.flatMap { it.products }
        listOf(orderedProducts.filter { it.equals(product) }.count())
    }.sum()
}
