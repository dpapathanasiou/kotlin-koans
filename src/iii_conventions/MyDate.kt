package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        // normalize in terms of days (do not need calendar precision)
        val thisDate = (this.year * 365) + (this.month * 31) + this.dayOfMonth
        val thatDate = (other.year * 365) +(other.month * 31) + other.dayOfMonth

        return thisDate - thatDate
    }
    operator fun plus(timeIntervals: RepeatedTimeInterval) = addTimeIntervals(timeIntervals.timeInterval, timeIntervals.number)
    operator fun plus(timeInterval: TimeInterval) = addTimeIntervals(timeInterval, 1)
}

operator fun MyDate.rangeTo(other: MyDate): DateRange {
    return DateRange(this, other)
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

operator fun TimeInterval.times(number: Int) = RepeatedTimeInterval(this, number)

class RepeatedTimeInterval(val timeInterval: TimeInterval, val number: Int)

class DateIterator(val dateRange:DateRange): Iterator<MyDate> {
    var head = dateRange.start
    override fun next(): MyDate {
        val next = head
        head = head.nextDay()
        return next
    }
    override fun hasNext(): Boolean = head <= dateRange.endInclusive
}

class DateRange(val start: MyDate, val endInclusive: MyDate): Iterable<MyDate> {
    operator fun contains(item: MyDate): Boolean {
        return start <= item && item <= endInclusive
    }

    override fun iterator(): Iterator<MyDate> = DateIterator(this)
}