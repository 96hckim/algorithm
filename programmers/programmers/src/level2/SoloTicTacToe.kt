package level2

fun main(args: Array<String>) = with(SoloTicTacToe()) {
    println(solution(arrayOf("O.X", ".O.", "..X")))  // 1
    println(solution(arrayOf("OOO", "...", "XXX")))  // 0
    println(solution(arrayOf("...", ".X.", "...")))  // 0
    println(solution(arrayOf("...", "...", "...")))  // 1
}

class SoloTicTacToe {
    fun solution(board: Array<String>): Int {
        val counts = board.flatMap { it.asIterable() }.groupingBy { it }.eachCount()
        val oCount = counts['O'] ?: 0
        val xCount = counts['X'] ?: 0

        if (oCount < xCount || oCount > xCount + 1) return 0

        fun getWinCount(player: Char): Int {
            val lines = listOf(
                board[0], board[1], board[2],  // Rows
                "${board[0][0]}${board[1][0]}${board[2][0]}",  // Columns
                "${board[0][1]}${board[1][1]}${board[2][1]}",
                "${board[0][2]}${board[1][2]}${board[2][2]}",
                "${board[0][0]}${board[1][1]}${board[2][2]}",  // Diagonals
                "${board[0][2]}${board[1][1]}${board[2][0]}"
            )
            return lines.count { it.all { char -> char == player } }
        }

        val oWinCount = getWinCount('O')
        val xWinCount = getWinCount('X')

        if (oWinCount > 0 && xWinCount > 0) return 0
        if (oWinCount == 1 && oCount <= xCount) return 0
        if (xWinCount == 1 && oCount != xCount) return 0

        return 1
    }
}