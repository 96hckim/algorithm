package level2

fun main(args: Array<String>) {
    val solution = SubArraySumFinder()

    val sequence1 = intArrayOf(1, 2, 3, 4, 5)
    val k1 = 7
    println("Result 1: ${solution.solution(sequence1, k1).contentToString()}") // [2, 3]

    val sequence2 = intArrayOf(1, 1, 1, 2, 3, 4, 5)
    val k2 = 5
    println("Result 2: ${solution.solution(sequence2, k2).contentToString()}") // [6, 6]

    val sequence3 = intArrayOf(2, 2, 2, 2, 2)
    val k3 = 6
    println("Result 3: ${solution.solution(sequence3, k3).contentToString()}") // [0, 2]
}

class SubArraySumFinder {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var start = 0
        var end = 0
        var sum = sequence[0]
        var shortest = Int.MAX_VALUE
        var answer = intArrayOf(-1, -1)

        while (start < sequence.size) {
            when {
                sum < k -> {
                    end += 1
                    if (end >= sequence.size) break
                    sum += sequence[end]
                }

                sum > k -> {
                    sum -= sequence[start]
                    start += 1
                }

                else -> {
                    val length = end - start + 1
                    if (length < shortest) {
                        shortest = length
                        answer = intArrayOf(start, end)
                    }
                    sum -= sequence[start]
                    start += 1
                }
            }
        }

        return if (answer[0] == -1) intArrayOf(0, 0) else answer
    }
}