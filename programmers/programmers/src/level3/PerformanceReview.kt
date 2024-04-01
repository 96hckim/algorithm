package level3

import java.util.*
import kotlin.math.max

fun main(args: Array<String>) = with(PerformanceReview()) {
    val scores = arrayOf(
        intArrayOf(2, 2),
        intArrayOf(1, 4),
        intArrayOf(3, 2),
        intArrayOf(3, 2),
        intArrayOf(2, 1)
    )
    val result = solution(scores)
    println("Result: $result") // 예상 출력: 4
}

class PerformanceReview {
    fun solution(scores: Array<IntArray>): Int {
        val (wanhoFirst, wanhoSecond) = scores.first()
        Arrays.sort(scores) { a: IntArray, b: IntArray -> if (a[0] == b[0]) a[1] - b[1] else b[0] - a[0] }

        var rank = 1
        var maxScore = 0
        val wanhoSum = wanhoFirst + wanhoSecond

        for ((first, second) in scores) {
            if (second < maxScore) {
                if (wanhoFirst == first && wanhoSecond == second) return -1
            } else {
                maxScore = max(maxScore, second)
                if (first + second > wanhoSum) rank++
            }
        }

        return rank
    }
}