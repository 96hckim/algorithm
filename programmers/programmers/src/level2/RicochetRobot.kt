package level2

import java.util.*

fun main(args: Array<String>) {
    val solution = Solution()

    val board1 = arrayOf("...D..R", ".D.G...", "....D.D", "D....D.", "..D....")
    println("Result 1: ${solution.solution(board1)}") // 7

    val board2 = arrayOf(".D.R", "....", ".G..", "...D")
    println("Result 2: ${solution.solution(board2)}") // -1
}

class Solution {
    data class Position(val x: Int, val y: Int, val distance: Int)

    fun solution(board: Array<String>): Int {
        val dx = listOf(-1, 1, 0, 0)
        val dy = listOf(0, 0, -1, 1)
        val n = board.size
        val m = board[0].length

        fun bfs(startX: Int, startY: Int): Position? {
            val visited = Array(n) { BooleanArray(m) { false } }
            val queue: Queue<Position> = LinkedList()
            queue.offer(Position(startX, startY, 0))
            visited[startX][startY] = true

            while (queue.isNotEmpty()) {
                val current = queue.poll()
                val x = current.x
                val y = current.y

                if (board[x][y] == 'G') return Position(x, y, current.distance)

                for (i in 0 until 4) {
                    var step = 1
                    var preX = x
                    var preY = y
                    while (true) {
                        val nx = x + dx[i] * step
                        val ny = y + dy[i] * step

                        if (nx in 0 until n && ny in 0 until m && board[nx][ny] != 'D') {
                            preX = nx
                            preY = ny
                            step += 1
                        } else {
                            if (!visited[preX][preY]) {
                                visited[preX][preY] = true
                                queue.offer(Position(preX, preY, current.distance + 1))
                            }
                            break
                        }
                    }
                }
            }

            return null
        }

        var start: Position? = null

        loop@ for (i in 0 until n) {
            for (j in 0 until m) {
                if (board[i][j] == 'R') {
                    start = Position(i, j, 0)
                    break@loop
                }
            }
        }

        start ?: return -1

        return bfs(start.x, start.y)?.distance ?: -1
    }
}