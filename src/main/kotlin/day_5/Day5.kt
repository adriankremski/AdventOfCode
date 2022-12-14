package day_5

import java.util.Stack

val test = """
    [P]     [C]         [M]
    [D]     [P] [B]     [V] [S]
    [Q] [V] [R] [V]     [G] [B]
    [R] [W] [G] [J]     [T] [M]     [V]
    [V] [Q] [Q] [F] [C] [N] [V]     [W]
    [B] [Z] [Z] [H] [L] [P] [L] [J] [N]
    [H] [D] [L] [D] [W] [R] [R] [P] [C]
    [F] [L] [H] [R] [Z] [J] [J] [D] [D]
     1   2   3   4   5   6   7   8   9
     """

val day5TestData = """
    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2
""".trimIndent()

fun day5() {
    val (stacksInput, commands) = day5Data.split("\n\n")
    val allStacks = createStacks(stacksInput)

    commands.filterNot { it.isLetter() }.split("\\s+".toRegex()).filterNot { it.isEmpty() }.chunked(3) {
        val (move, from, to) = it
        val sourceStack = allStacks[from.toInt()]
        val destStack = allStacks[to.toInt()]

        (0 until move.toInt()).forEach { _ ->
            destStack!!.push(sourceStack!!.pop())
        }
    }

    println(allStacks.map { it.value.pop() }.joinToString(""))
}

fun day5Part2() {
    val (stacksInput, commands) = day5Data.split("\n\n")
    val allStacks = createStacks(stacksInput)

    commands.filterNot { it.isLetter() }.split("\\s+".toRegex()).filterNot { it.isEmpty() }.chunked(3) {
        val (move, from, to) = it
        val sourceStack = allStacks[from.toInt()]
        val destStack = allStacks[to.toInt()]

        (0 until move.toInt()).map { sourceStack!!.pop() }.reversed().forEach {
            destStack!!.push(it)
        }
    }

    println(allStacks.map { it.value.pop() }.joinToString(""))
}

fun createStacks(input: String): Map<Int, Stack<Char>> {
    val lineLength = input.split("\n").first().length
    val lines = input.split("\n")

    val allStacks = mutableMapOf<Int, Stack<Char>>()

    (0 until lineLength).flatMap { columnNumber ->
        (lines.indices).map { lineNumber ->
            lineNumber to columnNumber
        }
    }.fold(mutableListOf<Char>()) { crates, index ->
        val nextChar = lines[index.first][index.second]

        if (nextChar.isLetter()) {
            crates.add(nextChar)
        }

        if (nextChar.isDigit()) {
            allStacks[nextChar.digitToInt()] = Stack<Char>().apply { addAll(crates.reversed())}
            mutableListOf()
        } else {
            crates
        }
    }

    return allStacks
}