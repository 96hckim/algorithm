package kit.sort

fun main(args: Array<String>) = with(Solution()) {
    val citations = intArrayOf(3, 0, 6, 1, 5)
    println("Return: ${solution(citations)}") // 3
}

class Solution {
    fun solution(citations: IntArray): Int {
        citations.sortDescending()
        return citations.indices.firstOrNull { citations[it] <= it } ?: citations.size
    }
}