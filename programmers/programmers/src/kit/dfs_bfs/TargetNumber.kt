package kit.dfs_bfs

fun main(args: Array<String>) = with(TargetNumber()) {
    val numbers1 = intArrayOf(1, 1, 1, 1, 1)
    val target1 = 3
    println("Result: ${solution(numbers1, target1)}") // 5

    val numbers2 = intArrayOf(4, 1, 2, 1)
    val target2 = 4
    println("Result: ${solution(numbers2, target2)}") // 2
}

class TargetNumber {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0

        fun dfs(index: Int, currentSum: Int) {
            if (index == numbers.size) {
                if (currentSum == target) answer++
                return
            }

            dfs(index + 1, currentSum + numbers[index])
            dfs(index + 1, currentSum - numbers[index])
        }

        dfs(0, 0)
        return answer
    }
}