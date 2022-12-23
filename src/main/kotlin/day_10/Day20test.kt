package aoc

import day_10.day10Data
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

val signalStrenghts2 = mutableMapOf<Int, Int>()

open class CPU {
    var register: Int = 1
    val clock = AtomicInteger()
    var counter = 0

    fun addx(value: Int) {
        clock.getAndIncrement()
        check()
        signalStrenghts2[clock.get()] = register
        clock.getAndIncrement()
        signalStrenghts2[clock.get()] = register
        check()
        register += value
            // signalStrenghts2[clock.get()] = register
    }

    fun noOp() {
        clock.getAndIncrement()
        check()
    }

    open fun check() {
        if (clock.get() % 40 - 20 == 0) {
            println("AdrianTest here, ${clock.get()}, ${register * clock.get()}")
            counter += register * clock.get()
        }
        crt()
    }

    fun crt() {
        if ((clock.get() - 1) % 40 == 0) {
            println()
        } else {
            val index = (clock.get() - 1) % 40
            if (index in register - 1 .. register + 1) { // sprint onscreen
                print("#")
            } else {
                print(".")
            }
        }
    }
}

class Day10(
    val testInput: Boolean = false
) {
    private var input = emptyList<String>()

    fun setup() {
        input = day10Data.split("\n")
    }

    fun part1(): Int {
        setup()
        val cpu = CPU()
        input.forEach { cmd ->
            val split = cmd.split(" ")
            if (split.size == 1) {
                cpu.noOp()
            } else {
                val (_, valu) = split
                cpu.addx(valu.toInt())
            }
        }

        return cpu.counter
    }

//    @Benchmark
//    fun part2() {
//        val cpu = CPU()
//        input.forEach { cmd ->
//            val split = cmd.split(" ")
//            if (split.size == 1) {
//                cpu.noOp()
//            } else {
//                val (_, valu) = split
//                cpu.addx(valu.toInt())
//            }
//        }
//
//        println()
//    }
}

fun main() {
    val day10 = Day10(true)

    // println("part one test: ${day10.part1()}") // 13140
    println("part one: ${day10.part1()}") // 15140

//    // day10.part2()
//    day10.part2() // BPJAZGAP
}