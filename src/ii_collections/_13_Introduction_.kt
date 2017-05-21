package ii_collections

import java.util.*

/*
 * This part of workshop was inspired by:
 * https://github.com/goldmansachs/gs-collections-kata
 */

fun Shop.getSetOfCustomers(): Set<Customer> {
    // Return a set containing all the customers of this shop
    return this.customers.toHashSet()
}

