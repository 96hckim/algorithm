package level3

import java.util.*

fun main(args: Array<String>) = with(TroopReturn()) {
    // 테스트 케이스 1
    val n1 = 3
    val roads1 = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3))
    val sources1 = intArrayOf(2, 3)
    val destination1 = 1
    println("Test Case 1: ${solution(n1, roads1, sources1, destination1).joinToString(", ")}") // 기대 결과: [1, 2]

    // 테스트 케이스 2
    val n2 = 5
    val roads2 = arrayOf(intArrayOf(1, 2), intArrayOf(1, 4), intArrayOf(2, 4), intArrayOf(2, 5), intArrayOf(4, 5))
    val sources2 = intArrayOf(1, 3, 5)
    val destination2 = 5
    println("Test Case 2: ${solution(n2, roads2, sources2, destination2).joinToString(", ")}") // 기대 결과: [2, -1, 0]
}

class TroopReturn {
    fun solution(n: Int, roads: Array<IntArray>, sources: IntArray, destination: Int): IntArray {
        // 각 지역 간 연결 정보를 저장할 인접 리스트 초기화
        val adjList = Array(n + 1) { mutableListOf<Int>() }
        roads.forEach { road ->
            adjList[road[0]].add(road[1])
            adjList[road[1]].add(road[0])
        }

        // 목적지로부터 모든 지역까지의 최단 거리를 계산 (BFS 사용)
        val distances = IntArray(n + 1) { -1 } // -1로 초기화
        distances[destination] = 0 // 목적지에서 목적지까지의 거리는 0
        val queue: Queue<Int> = LinkedList()
        queue.add(destination)

        while (queue.isNotEmpty()) {
            val current = queue.remove()
            for (next in adjList[current]) {
                if (distances[next] == -1) { // 아직 방문하지 않은 지역이라면
                    distances[next] = distances[current] + 1
                    queue.add(next)
                }
            }
        }

        // 각 부대원이 강철부대로 복귀하는 최단 시간 계산
        return sources.map { source ->
            distances[source]
        }.toIntArray()
    }
}