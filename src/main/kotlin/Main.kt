import aoc.signalStrenghts2
import day_1.day1
import day_1.day1Part2
import day_10.day10
import day_10.signalStrenghts
import day_13.day13
import day_2.day2
import day_2.day2Part2
import day_3.day3
import day_3.day3Part2
import day_4.day4
import day_4.day4Part2
import day_5.day5
import day_5.day5Part2
import day_6.day6
import day_7.day7
import day_8.day8

fun main(args: Array<String>) {
   day13()
}

fun printResult(index: Int) {
    println("$index. ${signalStrenghts[index]!! * index} - ${signalStrenghts2[index]!! * index}")
}
