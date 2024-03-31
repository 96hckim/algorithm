package level2

fun main(args: Array<String>) = with(InterceptorSystem()) {
    val targets = arrayOf(
        intArrayOf(4, 5),
        intArrayOf(4, 8),
        intArrayOf(10, 14),
        intArrayOf(11, 13),
        intArrayOf(5, 12),
        intArrayOf(3, 7),
        intArrayOf(1, 4)
    )
    println("Result : ${solution(targets)}") // 3
}

class InterceptorSystem {
    fun solution(targets: Array<IntArray>): Int {
        targets.sortBy { it[1] }

        var result = 0
        var end = 0

        for (target in targets) {
            val (currentStart, currentEnd) = target

            if (currentStart >= end) {
                end = currentEnd
                result++
            }
        }

        return result
    }
}