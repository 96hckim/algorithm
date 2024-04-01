package level3

fun main(args: Array<String>) = with(ContinuousPulseSubsequenceSum()) {
    val sequence = intArrayOf(2, 3, -6, 1, 3, -1, 2, 4)
    val result = solution(sequence)
    println("Result: $result") // 예상 출력: 10
}

class ContinuousPulseSubsequenceSum {
    fun solution(sequence: IntArray): Long {
        var maxSum: Long = 0
        var currentSumPositive = 0L
        var currentSumNegative = 0L
        var pulseSign = 1

        for (num in sequence) {
            // 펄스 수열에 따라 수열의 값을 변환하여 더하거나 빼줍니다.
            val positiveTransformed = (num * pulseSign).toLong()
            val negativeTransformed = (num * pulseSign * -1).toLong()
            pulseSign *= -1 // 다음 숫자를 위해 펄스 부호 변경

            currentSumPositive = (currentSumPositive + positiveTransformed).coerceAtLeast(0)
            currentSumNegative = (currentSumNegative + negativeTransformed).coerceAtLeast(0)

            // 두 변환된 수열 중 큰 값을 최대 합으로 선택
            maxSum = maxOf(maxSum, currentSumPositive, currentSumNegative)
        }

        return maxSum
    }
}