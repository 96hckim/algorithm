package level2

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt

fun main(args: Array<String>) = with(IntegerPairsBetweenCircles()) {
    val r1 = 2
    val r2 = 3
    println("Result: ${solution(r1, r2)}") // 20
}

class IntegerPairsBetweenCircles {
    fun solution(r1: Int, r2: Int): Long {
        var answer: Long = 0

        for (x in 1..r2) {
            val xSquared = x.toDouble() * x
            val minH = ceil(sqrt(r1.toDouble() * r1 - xSquared)).toLong()
            val maxH = floor(sqrt(r2.toDouble() * r2 - xSquared)).toLong()

            answer += (maxH - minH + 1)
        }

        return answer * 4
    }
}