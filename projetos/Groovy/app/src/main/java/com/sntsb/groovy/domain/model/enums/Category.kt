package com.sntsb.groovy.domain.model.enums

enum class Category {
    rock, house, mixed, jazz, pop, electro, none;

    companion object {
        fun from(value: String): Category {
            return Category.entries.find { it.name.equals(value, ignoreCase = true) } ?: none
        }
    }
}