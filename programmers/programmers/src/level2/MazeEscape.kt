package level2

import java.util.*

fun main(args: Array<String>) {
    val solution = MazeEscape()

    val maps1 = arrayOf("SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE")
    println("Result 1: ${solution.solution(maps1)}") // 16

    val maps2 = arrayOf("LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO")
    println("Result 2: ${solution.solution(maps2)}") // -1
}

class MazeEscape {
    data class Position(val x: Int, val y: Int, val distance: Int)

    fun solution(maps: Array<String>): Int {
        val dx = listOf(-1, 1, 0, 0)
        val dy = listOf(0, 0, -1, 1)
        val n = maps.size
        val m = maps[0].length

        fun bfs(startX: Int, startY: Int, target: Char): Position? {
            val visited = Array(n) { BooleanArray(m) { false } }
            val queue: Queue<Position> = LinkedList()
            queue.offer(Position(startX, startY, 0))
            visited[startX][startY] = true

            while (queue.isNotEmpty()) {
                val current = queue.poll()
                val x = current.x
                val y = current.y

                if (maps[x][y] == target) return Position(x, y, current.distance)

                for (i in 0 until 4) {
                    val nx = x + dx[i]
                    val ny = y + dy[i]

                    if (nx in 0 until n && ny in 0 until m && !visited[nx][ny] && maps[nx][ny] != 'X') {
                        visited[nx][ny] = true
                        queue.offer(Position(nx, ny, current.distance + 1))
                    }
                }
            }

            return null
        }

        var start: Position? = null
        var lever: Position? = null

        for (i in maps.indices) {
            for (j in maps[0].indices) {
                when (maps[i][j]) {
                    'S' -> start = Position(i, j, 0)
                    'L' -> lever = Position(i, j, 0)
                }
            }
        }

        start ?: return -1
        lever ?: return -1

        val toLever = bfs(start.x, start.y, 'L') ?: return -1
        val toExit = bfs(lever.x, lever.y, 'E') ?: return -1

        return toLever.distance + toExit.distance
    }
}