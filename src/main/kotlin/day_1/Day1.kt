package day_1

fun day1() {
    val maxLoad = day1Data.split("\n\n").map { elfLoad ->
        elfLoad.split("\n").sumOf { it.toIntOrNull() ?: 0 }
    }.max()
    println(maxLoad)
}

fun day1Part2() {
    val maxLoad = day1Data.split("\n\n").map { elfLoad ->
        elfLoad.split("\n").sumOf { it.toIntOrNull() ?: 0 }
    }.sortedDescending().subList(0, 3).sum()
    println(maxLoad)
}