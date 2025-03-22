package com.example.task1

class manager {
    fun <T : LibraryItem> buy(shop: Shop<T>): T { return shop.sell() }
}