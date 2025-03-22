package com.example.task1

import java.util.*

class LibraryManager(
    private val books: List<Book>,
    private val newspapers: List<Newspaper>,
    private val discs: List<Disc>,
    private val Manager: manager,
    private val digitizer: digitize
) {
    private val scanner = Scanner(System.`in`)

    fun start() {
        while (true) {
            println("Выберите тип объекта:")
            println("1. Показать книги")
            println("2. Показать газеты")
            println("3. Показать диски")
            println("4. Купить объект")
            println("5. Оцифровать объект")
            println("6. Фильтрация объектов")
            println("0. Выход")

            try {
                when (scanner.nextInt()) {
                    1 -> handleItems(books)
                    2 -> handleItems(newspapers)
                    3 -> handleItems(discs)
                    4 -> handleBuy()
                    5 -> handleDigitize()
                    6 -> handleFiltration()
                    0 -> return
                    else -> println("Неверный выбор, попробуйте еще раз.")
                }
            } catch (e: InputMismatchException) {
                println("Ошибка: введите число.")
                scanner.next()
            }
        }
    }

    private fun handleItems(items: List<LibraryItem>) {
        while (true) {
            println("Список объектов:")
            items.forEachIndexed { index, item ->
                println("${index + 1}. ${item.getShortInfo()}")
            }
            println("Выберите объект:")

            try {
                val choice = scanner.nextInt()
                if (choice == 0) return
                if (choice < 1 || choice > items.size) {
                    println("Неверный выбор, попробуйте еще раз.")
                    continue
                }
                val selectedItem = items[choice - 1]
                handleItemActions(selectedItem)
            } catch (e: InputMismatchException) {
                println("Ошибка: введите число.")
                scanner.next()
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
            println("5. Оцифровать")
            println("0. Назад")

            try {
                when (scanner.nextInt()) {
                    1 -> takeHome(item)
                    2 -> readInLibrary(item)
                    3 -> println(item.getDetailedInfo())
                    4 -> returnItem(item)
                    5 -> digitizeItem(item)
                    0 -> return
                    else -> println("Неверный выбор, попробуйте еще раз.")
                }
            } catch (exception: InputMismatchException) {
                println("Ошибка: введите число.")
                scanner.next()
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

    private fun digitizeItem(item: LibraryItem) {
        try {
            val disc = digitizer.Digitizer(item)
            println("Оцифрованный объект: ${disc.getDetailedInfo()}")
        } catch (exception: IllegalArgumentException) {
            println(exception.message)
        }
    }

    private fun handleBuy() {
        println("Выбор магазина:")
        println("1. Магазин книг")
        println("2. Магазин дисков")
        println("3. Газетный ларек")
        println("0. Назад")

        when (scanner.nextInt()) {
            1 -> {
                val book = Manager.buy(BookShop())
                println("Куплена книга: ${book.getDetailedInfo()}")
            }
            2 -> {
                val disc = Manager.buy(DiscShop())
                println("Куплен диск: ${disc.getDetailedInfo()}")
            }
            3 -> {
                val newspaper = Manager.buy(NewspaperShop())
                println("Куплена газета: ${newspaper.getDetailedInfo()}")
            }
            0 -> return
            else -> println("Неверный выбор, попробуйте еще раз.")
        }
    }

    private fun handleDigitize() {
        val items = books + newspapers
        println("Выберите объект для оцифровки:")
        items.forEachIndexed { index, item ->
            println("${index + 1}. ${item.getShortInfo()}")
        }
        println("0. Назад")

        val choice = scanner.nextInt()
        if (choice == 0) return
        if (choice < 1 || choice > items.size) {
            println("Неверный выбор, попробуйте еще раз.")
            return
        }
        val selectedItem = items[choice - 1]
        digitizeItem(selectedItem)
    }

    private fun handleFiltration() {
        val items = books + newspapers + discs
        println("Выбор объекта (типа) для фильтрации:")
        println("1. Книги")
        println("2. Газеты")
        println("3. Диски")
        println("0. Назад")

        when (scanner.nextInt()) {
            1 -> {
                val filteredBooks = filtration<Book>(items)
                println("Отфильтрованные книги:")
                filteredBooks.forEach { println(it.getDetailedInfo()) }
            }

            2 -> {
                val filteredNewspapers = filtration<Newspaper>(items)
                println("Отфильтрованные газеты:")
                filteredNewspapers.forEach { println(it.getDetailedInfo()) }
            }

            3 -> {
                val filteredDiscs = filtration<Disc>(items)
                println("Отфильтрованные диски:")
                filteredDiscs.forEach { println(it.getDetailedInfo()) }
            }

            0 -> return
            else -> println("Неверный выбор, попробуйте снова.")
        }
    }
}