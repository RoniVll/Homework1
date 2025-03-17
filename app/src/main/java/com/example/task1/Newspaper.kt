package com.example.task1

class Newspaper(
    id: Int,
    available: Boolean,
    name: String,
    val issueNumber: Int
) : LibraryItem(id, available, name) {
    override fun getDetailedInfo(): String {
        return "выпуск: $issueNumber газеты $name с id: $id доступен: ${if (isAvailable()) "Да" else "Нет"}"
    }
}