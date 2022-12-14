package day_2

import day2Data
import day2Data2

enum class Outcome(val points: Int, val code: String) {
    Win(6, "Z"), Draw(3, "Y"), Loss(0, "X")
}

enum class Choice(val opponentCode: String, val playerCode: String, val points: Int) {
    Rock("A", "X", 1) {
        override fun play(opponentChoice: Choice): Outcome = when(opponentChoice) {
            Rock -> Outcome.Draw
            Scissors -> Outcome.Win
            Paper -> Outcome.Loss
        }

        override fun expectedPlayerChoice(expectedOutcome: Outcome) = when(expectedOutcome) {
            Outcome.Win -> Paper
            Outcome.Draw -> Rock
            Outcome.Loss -> Scissors
        }
    },
    Paper("B", "Y", 2) {
        override fun play(opponentChoice: Choice): Outcome = when(opponentChoice) {
            Rock -> Outcome.Win
            Scissors -> Outcome.Loss
            Paper -> Outcome.Draw
        }

        override fun expectedPlayerChoice(expectedOutcome: Outcome) = when(expectedOutcome) {
            Outcome.Win -> Scissors
            Outcome.Draw -> Paper
            Outcome.Loss -> Rock
        }
    },
    Scissors("C", "Z", 3) {
        override fun play(opponentChoice: Choice): Outcome = when(opponentChoice) {
            Rock -> Outcome.Loss
            Scissors -> Outcome.Draw
            Paper -> Outcome.Win
        }

        override fun expectedPlayerChoice(expectedOutcome: Outcome) = when(expectedOutcome) {
            Outcome.Win -> Rock
            Outcome.Draw -> Scissors
            Outcome.Loss -> Paper
        }
    };

    abstract fun play(opponentChoice: Choice): Outcome
    abstract fun expectedPlayerChoice(expectedOutcome: Outcome): Choice
}

fun day2() {
    val totalScore = day2Data.split("\n").map { singleGameData ->
        with(singleGameData.split(" ")) {
            val opponentChoice = Choice.values().first { it.opponentCode == this[0] }
            val playerChoice = Choice.values().first { it.playerCode == this[1] }

            playerChoice.play(opponentChoice).points + playerChoice.points
        }
    }.sum()
    println(totalScore)
}

fun day2Part2() {
    val totalScore = day2Data.split("\n").map { singleGameData ->
        with(singleGameData.split(" ")) {
            val opponentChoice = Choice.values().first { it.opponentCode == this[0] }
            val expectedOutcome = Outcome.values().first { it.code == this[1] }

            val playerChoice = opponentChoice.expectedPlayerChoice(expectedOutcome)
            playerChoice.points + expectedOutcome.points
        }
    }.sum()
    println(totalScore)
}