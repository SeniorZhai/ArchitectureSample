package io.github.seniorzhai.architecturesample

import java.util.*

fun getRandomTime(): String {
    val calendar = Calendar.getInstance()
    calendar.set(2013, 5, 20)
    calendar.set(Calendar.HOUR_OF_DAY, 0)
    calendar.set(Calendar.MINUTE, 0)
    calendar.set(Calendar.SECOND, 0)
    val min = calendar.time.time
    val max = Date().time
    val randomDate = Math.random() * (max - min) + min
    calendar.timeInMillis = Math.round(randomDate)

    val month: Any = if (calendar.get(Calendar.MONTH) < 9) {
        "0${calendar.get(Calendar.MONTH) + 1}"
    } else {
        calendar.get(Calendar.MONTH) + 1
    }
    val day: Any = if (calendar.get(Calendar.DAY_OF_MONTH) < 10) {
        "0${calendar.get(Calendar.DAY_OF_MONTH)}"
    } else {
        calendar.get(Calendar.DAY_OF_MONTH)
    }
    return "${calendar.get(Calendar.YEAR)}$month$day"
}