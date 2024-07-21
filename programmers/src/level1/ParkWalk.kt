package level1

fun main(args: Array<String>) {
    val solution = ParkWalk()

    val park1 = arrayOf("SOO", "OOO", "OOO")
    val routes1 = arrayOf("E 2", "S 2", "W 1")
    val result1 = intArrayOf(2, 1)
    println(solution.solution(park1, routes1).contentToString())

    val park2 = arrayOf("SOO", "OXX", "OOO")
    val routes2 = arrayOf("E 2", "S 2", "W 1")
    val result2 = intArrayOf(0, 1)
    println(solution.solution(park2, routes2).contentToString())

    val park3 = arrayOf("OSO", "OOO", "OXO", "OOO")
    val routes3 = arrayOf("E 2", "S 3", "W 1")
    val result3 = intArrayOf(0, 0)
    println(solution.solution(park3, routes3).contentToString())
}

class ParkWalk {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        val rows = park.size
        val cols = park[0].length

        var startRow = -1
        var startCol = -1
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (park[i][j] == 'S') {
                    startRow = i
                    startCol = j
                    break
                }
            }
        }

        val dx = mapOf("N" to -1, "S" to 1, "W" to 0, "E" to 0)
        val dy = mapOf("N" to 0, "S" to 0, "W" to -1, "E" to 1)

        for (route in routes) {
            val (dir, distStr) = route.split(" ")
            val dist = distStr.toInt()

            val dRow = dx.getOrDefault(dir, 0)
            val dCol = dy.getOrDefault(dir, 0)

            var newRow = startRow
            var newCol = startCol

            for (i in 0 until dist) {
                newRow += dRow
                newCol += dCol

                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || park[newRow][newCol] == 'X') {
                    newRow = startRow
                    newCol = startCol
                    break
                }
            }

            startRow = newRow
            startCol = newCol
        }

        return intArrayOf(startRow, startCol)
    }
}