package day_8

data class Tree(
    val height: Int,
    val columnIndex: Int,
    val rowIndex: Int,
    val neighbourHeights: MutableMap<Pair<Int, Int>, Int?> = mutableMapOf(),
    var score: Int = 1
)

fun day8() {
    val grid = day8Data.split("\n").mapIndexed { rowIndex, line ->
        line.trim().mapIndexed { columnIndex, char ->
            Tree(
                height = char.digitToInt(),
                columnIndex = columnIndex,
                rowIndex = rowIndex
            )
        }
    }

    val trees = grid.flatten()

    trees.forEach {
        it.collectHighestTrees(grid)
        it.collectScores(grid)
    }

    val visibleTrees = trees.count { tree ->
        val result = tree.neighbourHeights.values.any { tree.height > (it ?: 0) }
        result
    }

    val highestScore = trees.maxOf{ it.score }

    println(highestScore)
}


fun Tree.collectHighestTrees(grid: List<List<Tree>>) {
    this.collectHighestTree(grid, columnIndex, rowIndex, -1, 0)
    this.collectHighestTree(grid, columnIndex, rowIndex, 0, -1)
    this.collectHighestTree(grid, columnIndex, rowIndex, 1, 0)
    this.collectHighestTree(grid, columnIndex, rowIndex, 0, 1)
}

fun Tree.collectScores(grid: List<List<Tree>>) {
    val score1 = collectScore(grid, columnIndex, rowIndex, -1, 0)
    val score2 = collectScore(grid, columnIndex, rowIndex, 0, -1)
    val score3 = collectScore(grid, columnIndex, rowIndex, 1, 0)
    val score4 = collectScore(grid, columnIndex, rowIndex, 0, 1)
    score = score1 * score2 * score3 * score4
}


fun Tree.collectHighestTree(
    grid: List<List<Tree>>,
    columnIndex: Int,
    rowIndex: Int,
    nextColumnIndex: Int,
    nextRowIndex: Int
) {
    if (neighbourHeights[nextColumnIndex to nextRowIndex] == null) {
        neighbourHeights[nextColumnIndex to nextRowIndex] =
            collectHighestTreeFromNeighbours(
                grid,
                columnIndex,
                rowIndex,
                nextColumnIndex = nextColumnIndex,
                nextRowIndex = nextRowIndex
            )
    }
}

fun collectHighestTreeFromNeighbours(
    grid: List<List<Tree>>,
    columnIndex: Int,
    rowIndex: Int,
    nextColumnIndex: Int,
    nextRowIndex: Int
): Int {
    val treeColumnIndex = columnIndex + nextColumnIndex
    val treeRowIndex = rowIndex + nextRowIndex
    val tree = grid.getOrNull(treeRowIndex)?.getOrNull(treeColumnIndex)

    return tree?.let { tree ->
        val neighbourHeight = tree.neighbourHeights[nextColumnIndex to nextRowIndex]

        if (neighbourHeight != null) {
            maxOf(neighbourHeight, tree.height)
        } else {
            val height =
                collectHighestTreeFromNeighbours(grid, treeColumnIndex, treeRowIndex, nextColumnIndex, nextRowIndex)
            tree.neighbourHeights[nextColumnIndex to nextRowIndex] = height
            maxOf(height, tree.height)
        }
    } ?: -1
}

fun Tree.collectScore(
    grid: List<List<Tree>>,
    columnIndex: Int,
    rowIndex: Int,
    nextColumnIndex: Int,
    nextRowIndex: Int
): Int {
    var treeColumnIndex = columnIndex + nextColumnIndex
    var treeRowIndex = rowIndex + nextRowIndex

    var tree: Tree? = grid.getOrNull(treeRowIndex)?.getOrNull(treeColumnIndex) ?: return 1

    var score = 0

    while (tree != null) {
        if (tree.height >= height) {
            score += 1
            tree = null
        } else {
            treeRowIndex += nextRowIndex
            treeColumnIndex += nextColumnIndex
            tree = grid.getOrNull(treeRowIndex)?.getOrNull(treeColumnIndex)
            score++
        }
    }

    return score
}

