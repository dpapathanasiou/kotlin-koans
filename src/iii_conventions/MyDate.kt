package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        // normalize in terms of days (do not need calendar precision)
        val thisDate = (this.year * 365) + (this.month * 31) + this.dayOfMonth
        val thatDate = (other.year * 365) +(other.month * 31) + other.dayOfMonth

        return thisDate - thatDate
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = todoTask27()

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate)
