package day_3

import java.util.Collections
import kotlin.math.floor

private val lowercaseItemsPriority = ('a'..'z').mapIndexed { index, char -> char to index + 1 }.toMap()
private val uppercaseItemsPriority = ('A'..'Z').mapIndexed { index, char -> char to index + 27 }.toMap()
private val itemsPriority = lowercaseItemsPriority + uppercaseItemsPriority
private fun Char.priority() = itemsPriority[this] ?: 0

fun day3() {
    val sumOfPriorities = day3Data.split("\n").sumOf { rucksack ->
        rucksack.chunked(rucksack.length/2)
            .map { it.toSet() }
            .reduce { first, second -> first intersect second}
            .single()
            .priority()
    }

    println(sumOfPriorities)
}

fun day3Part2() {
    val sumOfPriorities = day3Data.split("\n")
        .map { it.toSet() }
        .chunked(3)
        .sumOf { it.reduce { acc, compartment -> acc intersect compartment }.single().priority() }

    println(sumOfPriorities)
}