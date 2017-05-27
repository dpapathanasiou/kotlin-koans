package iii_conventions

class Invokable {
    var invocations: Int = 0
    operator fun invoke(): Invokable {
        invocations++
        return this
    }
    fun getNumberOfInvocations(): Int = invocations
}

fun task31(invokable: Invokable): Int {
    return invokable()()()().getNumberOfInvocations()
}
