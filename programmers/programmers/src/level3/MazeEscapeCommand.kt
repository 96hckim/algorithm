package level3

import kotlin.math.abs

fun main(args: Array<String>) = with(MazeEscapeCommand()) {
    // 첫 번째 테스트 케이스
    val n1 = 3
    val m1 = 4
    val x1 = 2
    val y1 = 3
    val r1 = 3
    val c1 = 1
    val k1 = 5
    val result1 = solution(n1, m1, x1, y1, r1, c1, k1)
    println("Result 1: $result1") // 예상 출력: "dllrl"

    // 두 번째 테스트 케이스
    val n2 = 2
    val m2 = 2
    val x2 = 1
    val y2 = 1
    val r2 = 2
    val c2 = 2
    val k2 = 2
    val result2 = solution(n2, m2, x2, y2, r2, c2, k2)
    println("Result 2: $result2") // 예상 출력: "dr"

    // 세 번째 테스트 케이스
    val n3 = 3
    val m3 = 3
    val x3 = 1
    val y3 = 2
    val r3 = 3
    val c3 = 3
    val k3 = 4
    val result3 = solution(n3, m3, x3, y3, r3, c3, k3)
    println("Result 3: $result3") // 예상 출력: "impossible"
}

class MazeEscapeCommand {
    fun solution(n: Int, m: Int, x: Int, y: Int, r: Int, c: Int, k: Int): String {
        if (abs(k - getDistance(x, y, r, c)) % 2 != 0) return "impossible"

        val dx = arrayOf(1, 0, 0, -1)
        val dy = arrayOf(0, -1, 1, 0)
        val direction = arrayOf('d', 'l', 'r', 'u')

        val path = StringBuilder()
        var result: String? = null

        fun dfs(row: Int, col: Int, depth: Int) {
            if (result != null) return
            if (depth + getDistance(row, col, r, c) > k) return
            if (depth == k) {
                if (row == r && col == c) result = path.toString()
                return
            }

            for (i in 0 until 4) {
                val nx = row + dx[i]
                val ny = col + dy[i]

                if (nx in 1..n && ny in 1..m) {
                    path.append(direction[i])
                    dfs(nx, ny, depth + 1)
                    path.deleteCharAt(path.lastIndex)
                }
            }
        }

        dfs(x, y, 0)

        return result ?: "impossible"
    }

    private fun getDistance(x: Int, y: Int, r: Int, c: Int): Int {
        return abs(x - r) + abs(y - c)
    }
}