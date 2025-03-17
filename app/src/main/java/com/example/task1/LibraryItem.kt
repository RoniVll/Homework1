package com.example.task1

abstract class LibraryItem(
    val id: Int,
    private var available: Boolean,
    val name: String
) {
    fun isAvailable(): Boolean = available
    fun setAvailable(newAvailability: Boolean) {
        available = newAvailability
    }

    open fun getShortInfo(): String {
        return "$name доступна: ${if (isAvailable()) "Да" else "Нет"}"
    }

    abstract fun getDetailedInfo(): String
}