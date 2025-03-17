package com.example.task1

class Disc(
    id: Int,
    available: Boolean,
    name: String,
    val discType: String
) : LibraryItem(id, available, name) {
    override fun getDetailedInfo(): String {
        return "$discType $name доступен: ${if (isAvailable()) "Да" else "Нет"}"
    }
}