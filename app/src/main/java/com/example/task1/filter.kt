package com.example.task1

inline fun <reified T> filtration(items: List<Any>):
        List<T> { return items.filterIsInstance<T>() }