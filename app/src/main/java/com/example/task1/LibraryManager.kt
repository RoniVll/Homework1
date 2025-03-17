package com.example.task1

import java.util.*

class LibraryManager(
    private val books: List<Book>,
    private val newspapers: List<Newspaper>,
    private val discs: List<Disc>
) {
    private val scanner = Scanner(System.`in`)

    fun start() {
        while (true) {
            println("Выберите тип объекта:")
            println("1. Показать книги")
            println("2. Показать газеты")
            println("3. Показать диски")
            println("0. Выход")

            try {
                when (scanner.nextInt()) {
                    1 -> handleItems(books)
                    2 -> handleItems(newspapers)
                    3 -> handleItems(discs)
                    0 -> return
                    else -> println("Неверный выбор, попробуйте снова.")
                }
            } catch (e: InputMismatchException) {
                println("Ошибка: введите число.")
                scanner.next() // Очистка некорректного ввода
            }
        }
    }

    private fun handleItems(items: List<LibraryItem>) {
        while (true) {
            println("Список объектов:")
            items.forEachIndexed { index, item ->
                println("${index + 1}. ${item.getShortInfo()}")
            }
            println("Выберите объект (0 для возврата):")

            try {
                val choice = scanner.nextInt()
                if (choice == 0) return
                if (choice < 1 || choice > items.size) {
                    println("Неверный выбор, попробуйте снова.")
                    continue
                }
                val selectedItem = items[choice - 1]
                handleItemActions(selectedItem)
            } catch (e: InputMismatchException) {
                println("Ошибка: введите число.")
                scanner.next() // Очистка некорректного ввода
            }
        }
    }

    private fun handleItemActions(item: LibraryItem) {
        while (true) {
            println("Выберите действие:")
            println("1. Взять домой")
            println("2. Читать в читальном зале")
            println("3. Показать подробную информацию")
            println("4. Вернуть")
            println("0. Назад")

            try {
                when (scanner.nextInt()) {
                    1 -> takeHome(item)
                    2 -> readInLibrary(item)
                    3 -> println(item.getDetailedInfo())
                    4 -> returnItem(item)
                    0 -> return
                    else -> println("Неверный выбор, попробуйте снова.")
                }
            } catch (e: InputMismatchException) {
                println("Ошибка: введите число.")
                scanner.next() // Очистка некорректного ввода
            }
        }
    }

    private fun takeHome(item: LibraryItem) {
        if (item is Newspaper) {
            println("Газеты нельзя брать домой.")
            return
        }
        if (!item.isAvailable()) {
            println("Объект недоступен.")
            return
        }
        item.setAvailable(false)
        println("${item::class.simpleName} ${item.id} взяли домой.")
    }

    private fun readInLibrary(item: LibraryItem) {
        if (item is Disc) {
            println("Диски нельзя читать в читальном зале.")
            return
        }
        if (!item.isAvailable()) {
            println("Объект недоступен.")
            return
        }
        item.setAvailable(false)
        println("${item::class.simpleName} ${item.id} взяли в читальный зал.")
    }

    private fun returnItem(item: LibraryItem) {
        if (item.isAvailable()) {
            println("Объект уже доступен.")
            return
        }
        item.setAvailable(true)
        println("${item::class.simpleName} ${item.id} вернули.")
    }
}