package kit.graph

import java.util.*

fun main(args: Array<String>) = with(FarthestNode()) {
    val n = 6
    val vertex = arrayOf(
        intArrayOf(3, 6), intArrayOf(4, 3), intArrayOf(3, 2),
        intArrayOf(1, 3), intArrayOf(1, 2), intArrayOf(2, 4),
        intArrayOf(5, 2)
    )
    println("Return: ${solution(n, vertex)}") // 3
}

class FarthestNode {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        val graph = MutableList(n + 1) { mutableListOf<Int>() }
        val distance = IntArray(n + 1) { -1 }
        val queue: Queue<Int> = LinkedList()

        // 그래프 구성
        edge.forEach {
            graph[it[0]].add(it[1])
            graph[it[1]].add(it[0])
        }

        // BFS 초기 설정
        queue.add(1)
        distance[1] = 0

        // BFS 실행
        while (queue.isNotEmpty()) {
            val current = queue.poll()

            graph[current].forEach { neighbor ->
                if (distance[neighbor] == -1) {
                    distance[neighbor] = distance[current] + 1
                    queue.add(neighbor)
                }
            }
        }

        // 가장 멀리 떨어진 노드의 개수 계산
        val maxDistance = distance.maxOrNull() ?: 0
        return distance.count { it == maxDistance }
    }
}