package com.example.task1

interface Shop<T : LibraryItem> {
    fun sell(): T
}
class BookShop : Shop<Book> {
    override fun sell(): Book {
        return Book(13, true, "Приключения Тома Сойера", 320, "Марк Твен")
    }
}
class DiscShop : Shop<Disc> {
    override fun sell(): Disc {
        return Disc(14, true, "Готика 2: Ночь Ворона", "CD")
    }
}
class NewspaperShop : Shop<Newspaper> {
    override fun sell(): Newspaper {
        return Newspaper(15, true, "Пульс города", 83, 3)
    }
}