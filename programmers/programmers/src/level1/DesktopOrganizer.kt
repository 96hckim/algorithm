package level1

fun main(args: Array<String>) {
    val solution = DesktopOrganizer()

    val wallpaper1 = arrayOf(".#...", "..#..", "...#.")
    val result1 = intArrayOf(0, 1, 3, 4)
    println(solution.solution(wallpaper1).contentToString())

    val wallpaper2 = arrayOf(
        "..........",
        ".....#....",
        "......##..",
        "...##.....",
        "....#....."
    )
    val result2 = intArrayOf(1, 3, 5, 8)
    println(solution.solution(wallpaper2).contentToString())

    val wallpaper3 = arrayOf(
        ".##...##.",
        "#..#.#..#",
        "#...#...#",
        ".#.....#.",
        "..#...#..",
        "...#.#...",
        "....#...."
    )
    val result3 = intArrayOf(0, 0, 7, 9)
    println(solution.solution(wallpaper3).contentToString())

    val wallpaper4 = arrayOf("..", "#.")
    val result4 = intArrayOf(1, 0, 2, 1)
    println(solution.solution(wallpaper4).contentToString())
}

class DesktopOrganizer {
    fun solution(wallpaper: Array<String>): IntArray {
        var lux = wallpaper.size
        var luy = wallpaper[0].length
        var rdx = 0
        var rdy = 0

        wallpaper.forEachIndexed { i, row ->
            row.forEachIndexed { j, char ->
                if (char == '#') {
                    lux = minOf(lux, i)
                    luy = minOf(luy, j)
                    rdx = maxOf(rdx, i + 1)
                    rdy = maxOf(rdy, j + 1)
                }
            }
        }

        return intArrayOf(lux, luy, rdx, rdy)
    }
}
