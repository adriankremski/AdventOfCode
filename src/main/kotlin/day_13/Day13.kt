package day_13

val testData = """
    [1,1,3,1,1]
    [1,1,5,1,1]

    [[1],[2,3,4]]
    [[1],4]

    [9]
    [[8,7,6]]

    [[4,4],4,4]
    [[4,4],4,4,4]

    [7,7,7,7]
    [7,7,7]

    []
    [3]

    [[[]]]
    [[]]

    [1,[2,[3,[4,[5,6,7]]]],8,9]
    [1,[2,[3,[4,[5,6,0]]]],8,9]
""".trimIndent()

fun day13() {
    testData.split("\n").filterNot { it.isEmpty() }.chunked(2) {
        val firstSignal = it.first().trim()
        val secondSignal = it.last().trim()

        val firstSignalValues = collectArray(0, firstSignal.toCharArray()).second.mapValues()
        val secondSignalValues = collectArray(0, secondSignal.toCharArray()).second.mapValues()

        println(firstSignalValues)
        println(secondSignalValues)
    }
}

fun isInRightOrder(first: List<Any>, second: List<Any>): Boolean? {
    for (index in 0..first.size) {
        val firstValue = first[index]
        val secondValue = second[in

        if (firstValue is Int && secondValue is Int) {
            if (firstValue < secondValue) {
                return true
            }
        } else if (firstValue is List<*> && secondValue is List<*>) {
            val isInRightOrder = isInRightOrder(firstValue as List<Any>, secondValue as List<Any>)
            if (isInRightOrder != null) return isInRightOrder
        }
    }

    if (first.size < second.size) {
        return false
    }
    return null
}

fun List<Any>.mapValues() = map {
    if ((it as? Char)?.isDigit() == true) {
        it.digitToInt()
    } else if ((it as? String)?.toIntOrNull() != null) {
        it.toIntOrNull()
    } else {
        it
    }
}

fun collectArray(startIndex: Int, array: CharArray): Pair<Int, List<Any>> {
    var values = mutableListOf<Any>()
    var index = startIndex
    var end = false

    while (index < array.size && !end) {
        val char = array[index]
        if (char == ']') {
            end = true
            index++
        } else if (char.isDigit()) {
            val previousChar = (values.lastOrNull() as? Char)
            val previousValue = (values.lastOrNull() as? String)

            if (previousChar?.isDigit() == true && array.getOrNull(index - 1)?.isDigit() == true) {
                values[values.size - 1] = "${previousChar}${char}"
            } else if (previousValue != null && array.getOrNull(index - 1)?.isDigit() == true) {
                values[values.size - 1] = "${previousValue}${char}"
            } else {
                values.add(char)
            }
            index++
        } else if (char == '[') {
            if (index == 0) {
                val data = collectArray(startIndex = index + 1, array)
                values = data.second.toMutableList()
                index = data.first
            } else {
                val data = collectArray(startIndex = index + 1, array)
                values.add(data.second)
                index = data.first
            }
        } else {
            index++
        }
    }

    return index to values
}

data class Signal(
    val signalValues: List<Any>
)