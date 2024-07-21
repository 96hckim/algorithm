package kit.brute_force

fun main(args: Array<String>) = with(Fatigue()) {
    val k = 80
    val dungeons = arrayOf(intArrayOf(80, 20), intArrayOf(50, 40), intArrayOf(30, 10))
    println("Result: ${solution(k, dungeons)}") // 3
}

class Fatigue {
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        var answer = 0
        val visited = BooleanArray(dungeons.size)

        fun dfs(k: Int, count: Int) {
            answer = maxOf(answer, count)

            for (i in dungeons.indices) {
                if (!visited[i] && dungeons[i][0] <= k) {
                    visited[i] = true
                    dfs(k - dungeons[i][1], count + 1)
                    visited[i] = false
                }
            }
        }

        dfs(k, 0)
        return answer
    }
}