package com.example.task1

class digitize {
    fun Digitizer(item: LibraryItem): Disc {
        return when (item) {
            is Book -> Disc(10, true, "Оцифрованная книга: ${item.name}", "CD")
            is Newspaper -> Disc(11, true, "Оцифрованная газета: ${item.name}", "CD")
            else -> throw IllegalArgumentException("Данный объект нельзя оцифровать.")
        }
    }
}