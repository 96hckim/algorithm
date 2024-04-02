package kit.binary_search

fun main(args: Array<String>) = with(ImmigrationCheck()) {
    val n = 6
    val times = intArrayOf(7, 10)
    println("Return: ${solution(n, times)}") // 28
}

class ImmigrationCheck {
    fun solution(n: Int, times: IntArray): Long {
        times.sort()
        var left = 1L
        var right = n.toLong() * times.last() // 가장 오래 걸리는 심사대에서 모든 사람이 심사받는 경우
        var answer = right

        while (left <= right) {
            val mid = (left + right) / 2 // 중간값을 이용해 검사
            var count = 0L // mid 시간 동안 심사받을 수 있는 사람 수

            // 각 심사대에서 mid 시간 동안 몇 명이 심사를 받을 수 있는지 계산
            for (time in times) {
                count += mid / time
                if (count >= n) break // 모든 사람을 심사할 수 있다면 반복 종료
            }

            if (count < n) { // n명을 심사할 수 없는 경우
                left = mid + 1
            } else { // n명 이상을 심사할 수 있는 경우
                right = mid - 1
                answer = mid
            }
        }

        return answer
    }
}