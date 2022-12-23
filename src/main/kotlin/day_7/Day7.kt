package day_7

data class Node(
    val parentNode: Node? = null,
    val name: String,
    var size: Int? = null,
    val childNodes: MutableList<Node> = mutableListOf()
) {
    val totalSize: Int
        get() = (size ?: 0) + childNodes.sumOf { it.totalSize }
}

fun day7() {
    val mainNode: Node? = Node(name = "/")

    val data = day7Data.split("\n").map { line ->
        line.removePrefix("$").trim()
    }.fold(mainNode to listOf<Node>()) { data, it ->
        var currentNode = data.first
        val nodes = data.second.toMutableList()

        currentNode = when {
            it == "cd /" -> {
                nodes.add(mainNode!!)
                mainNode
            }
            it == "cd .." -> {
                currentNode?.parentNode
            }
            it.startsWith("cd") -> {
                val childNode = Node(
                    parentNode = currentNode,
                    name = it.split(" ").last(),
                )
                currentNode?.childNodes?.add(childNode)
                nodes.add(childNode)
                childNode
            }
            !it.startsWith("dir") && !it.startsWith("ls")-> {
                val size = it.split(" ").first().toInt()
                currentNode?.size = (currentNode?.size ?: 0) + size
                currentNode
            }
            else -> currentNode
        }

        currentNode to nodes
    }

    // Part 1
    println(data.second.map { it.totalSize }.filterNot { it >= 100000 }.sum())

    // Part 2
    val spaceAvailable = 70000000
    val requiredUnusedSpace = 30000000
    val spaceUsed = mainNode!!.totalSize
    val spaceLeft = spaceAvailable - spaceUsed
    println(data.second.map{ it.totalSize }.filter { it + spaceLeft >= requiredUnusedSpace }.minOf { it  })
}