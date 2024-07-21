package kit.stack_queue

import kotlin.math.ceil

fun main(args: Array<String>) = with(FeatureDevelopment()) {
    val progresses1 = intArrayOf(93, 30, 55)
    val speeds1 = intArrayOf(1, 30, 5)
    println("Return: ${solution(progresses1, speeds1).joinToString()}") // [2, 1]

    val progresses2 = intArrayOf(95, 90, 99, 99, 80, 99)
    val speeds2 = intArrayOf(1, 1, 1, 1, 1, 1)
    println("Return: ${solution(progresses2, speeds2).joinToString()}") // [1, 3, 2]
}

class FeatureDevelopment {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val days = progresses.mapIndexed { index, progress ->
            ceil((100 - progress).toDouble() / speeds[index])
        }

        var currentMaxDay = days.first()
        var count = 1
        val answer = mutableListOf<Int>()

        for (i in 1..days.lastIndex) {
            if (days[i] <= currentMaxDay) {
                count++
            } else {
                answer.add(count)
                count = 1
                currentMaxDay = days[i]
            }
        }
        answer.add(count)

        return answer.toIntArray()
    }
}