package day_4

fun day4() {
    val result = day4Data
        .split("\n")
        .flatMap { it.split(",") }
        .map { range ->
            with(range.split("-")) {
                (first().toInt()..last().toInt()).toSet()
            }
        }
        .chunked(2)
        .count { ranges -> ranges.contains(ranges.first() intersect ranges.last()) }

    println(result)
}

fun day4Part2() {
    val result = day4Data
        .split("\n")
        .flatMap { it.split(",") }
        .map { range ->
            with(range.split("-")) {
                (first().toInt()..last().toInt()).toSet()
            }
        }
        .chunked(2)
        .count { ranges -> (ranges.first() intersect ranges.last()).isNotEmpty() }

    println(result)
}