package vi_generics

import java.util.*

fun <T, C: MutableCollection<T>> Collection<T>.partitionTo(a: C, b: C, pred: (T) -> Boolean): Pair<C, C> {
    for( e in this )
        if( pred(e) )
            a.add(e)
        else
            b.add(e)

    return Pair(a, b)
}

fun List<String>.partitionWordsAndLines(): Pair<List<String>, List<String>> {
    return partitionTo(ArrayList<String>(), ArrayList()) { s -> !s.contains(" ") }
}

fun Set<Char>.partitionLettersAndOtherSymbols(): Pair<Set<Char>, Set<Char>> {
    return partitionTo(HashSet<Char>(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z'}
}