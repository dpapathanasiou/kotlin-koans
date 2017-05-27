package iv_properties

class LazyPropertyUsingDelegates(val initializer: () -> Int) {
    val lazyValue: Int by lazy(initializer)
}
