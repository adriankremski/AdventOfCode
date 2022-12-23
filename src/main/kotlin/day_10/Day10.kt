package day_10

val signalStrenghts = mutableMapOf<Int, Int>()

fun day10() {
    var currentAddx = 1
    var cycle = 1

    day10Data.split("\n").forEach {
        if (it == "noop") {
            signalStrenghts[cycle++] = currentAddx
            println("${cycle -1 } = $currentAddx, ${it}")
        } else if (it.startsWith("addx")) {
            val value = it.split(" ")[1].toInt()
            cycle = cycle + 1
            signalStrenghts[cycle] = currentAddx
            cycle = cycle + 1
            println("${cycle -1 } = $currentAddx, ${it}")
            signalStrenghts[cycle] = currentAddx
            currentAddx += value
            println("${cycle -1 } = $currentAddx, ${it}")
        }
    }

    val result = signalStrenghts[20]!! * 20 + signalStrenghts[60]!! * 60 + signalStrenghts[100]!! * 100 +
            signalStrenghts[140]!! * 140 + signalStrenghts[180]!! * 180 + signalStrenghts[220]!! * 220

    println("AdrianTest: ${result}")
    signalStrenghts.keys.forEach {
        //printResult(it)
    }

    //println(result)
//    printResult(20)
//    printResult(60)
//    printResult(100)
//    printResult(140)
//    printResult(180)
//    printResult(220)
}
