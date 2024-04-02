package kit.heap

import java.util.*

fun main(args: Array<String>) = with(DiskController()) {
    val jobs = arrayOf(intArrayOf(0, 3), intArrayOf(1, 9), intArrayOf(2, 6))
    println("Return: ${solution(jobs)}") // 9
}

class DiskController {
    fun solution(jobs: Array<IntArray>): Int {
        jobs.sortBy { it[0] }
        val pq = PriorityQueue<IntArray>(compareBy { it[1] })
        var answer = 0
        var count = 0
        var now = 0
        var index = 0

        while (count < jobs.size) {
            while (index < jobs.size && jobs[index][0] <= now) {
                pq.add(jobs[index++])
            }

            if (pq.isEmpty()) {
                now = jobs[index][0]
            } else {
                val job = pq.poll()
                now += job[1]
                answer += now - job[0]
                count++
            }
        }

        return answer / jobs.size
    }
}