package com.example.task1

fun main() {
    val books = listOf(
        Book(1, true, "Властелин колец", 752, "Джон Рональд Руэл Толкин"),
        Book(2, true, "Ведьмак", 1344, "Анджей Сапковский"),
        Book(3, false, "Гарри Поттер", 4416, "Джоан Роулинг"),
        Book(4, false, "Маленькие женщины", 384, "Луиза Мэй Олкотт"),
        Book(5, true, "Свинка Пеппа", 52, "Григорий Пушкин")
    )
    val newspapers = listOf(
        Newspaper(6, false, "Новостной вихрь", 800),
        Newspaper(7, true, "Городские сплетни", 355),
        Newspaper(8, false, "Умные перья", 55)

    )
    val discs = listOf(
        Disc(9, true, "Мстители", "DVD"),
        Disc(10, false, "Аватар", "CD"),
        Disc(11, false, "Титаник", "DVD"),
        Disc(12, true, "Гордость и предубеждение", "CD")
    )

    val libraryManager = LibraryManager(books, newspapers, discs)
    libraryManager.start()
}