package i_introduction._4_Lambdas

fun task4(collection: Collection<Int>): Boolean {
    return collection.filter({ i: Int -> (0 == i % 42) }).isNotEmpty()
}




