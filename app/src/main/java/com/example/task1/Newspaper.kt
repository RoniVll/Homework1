package com.example.task1

class Newspaper(
    id: Int,
    available: Boolean,
    name: String,
    val issueNumber: Int,
    val month: Int
) : LibraryItem(id, available, name) {

    private val monthNames = listOf("Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль",
        "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь")

    override fun getDetailedInfo(): String {
        return "выпуск: $issueNumber газеты $name за ${monthNames[month-1]} с id: $id доступен: " +
                "${if (isAvailable()) "Да" else "Нет"}"
    }
}