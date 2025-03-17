package com.example.task1

class Book(
    id: Int,
    available: Boolean,
    name: String,
    val pageCount: Int,
    val author: String
) : LibraryItem(id, available, name) {
    override fun getDetailedInfo(): String {
        return "книга: $name ($pageCount стр.) автора: $author с id: $id доступна: ${if (isAvailable()) "Да" else "Нет"}"
    }
}