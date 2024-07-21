package level1

fun main(args: Array<String>) {
    val solution = Coloring()

    val n1 = 8
    val m1 = 4
    val section1 = intArrayOf(2, 3, 6)
    println("Result 1: ${solution.solution(n1, m1, section1)}") // 2

    val n2 = 5
    val m2 = 4
    val section2 = intArrayOf(1, 3)
    println("Result 2: ${solution.solution(n2, m2, section2)}") // 1

    val n3 = 4
    val m3 = 1
    val section3 = intArrayOf(1, 2, 3, 4)
    println("Result 3: ${solution.solution(n3, m3, section3)}") // 4
}

class Coloring {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var start = section.first()
        var rolling = 1

        for (i in section) {
            if (i > start + m - 1) {
                start = i
                rolling++
            }
        }

        return rolling
    }
}
