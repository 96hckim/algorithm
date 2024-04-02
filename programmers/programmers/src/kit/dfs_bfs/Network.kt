package kit.dfs_bfs

fun main(args: Array<String>) = with(Solution()) {
    val n1 = 3
    val computers1 = arrayOf(
        intArrayOf(1, 1, 0),
        intArrayOf(1, 1, 0),
        intArrayOf(0, 0, 1)
    )
    println("Return: ${solution(n1, computers1)}") // 2

    val n2 = 3
    val computers2 = arrayOf(
        intArrayOf(1, 1, 0),
        intArrayOf(1, 1, 1),
        intArrayOf(0, 1, 1)
    )
    println("Return: ${solution(n2, computers2)}") // 1
}

class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        val visited = BooleanArray(n) { false }

        fun dfs(start: Int) {
            visited[start] = true
            for (i in 0 until n) {
                if (computers[start][i] == 1 && !visited[i]) {
                    dfs(i)
                }
            }
        }

        for (i in 0 until n) {
            if (!visited[i]) {
                dfs(i)
                answer++
            }
        }

        return answer
    }
}