package kit.brute_force

fun main(args: Array<String>) = with(MinimumRectangle()) {
    val sizes1 = arrayOf(intArrayOf(60, 50), intArrayOf(30, 70), intArrayOf(60, 30), intArrayOf(80, 40))
    println("Result: ${solution(sizes1)}") // 4000

    val sizes2 = arrayOf(intArrayOf(10, 7), intArrayOf(12, 3), intArrayOf(8, 15), intArrayOf(14, 7), intArrayOf(5, 15))
    println("Result: ${solution(sizes2)}") // 120

    val sizes3 = arrayOf(intArrayOf(14, 4), intArrayOf(19, 6), intArrayOf(6, 16), intArrayOf(18, 7), intArrayOf(7, 11))
    println("Result: ${solution(sizes3)}") // 133
}

class MinimumRectangle {
    fun solution(sizes: Array<IntArray>): Int {
        var maxW = 0
        var maxH = 0
        for (size in sizes) {
            val (w, h) = size.sorted()
            maxW = maxOf(maxW, w)
            maxH = maxOf(maxH, h)
        }
        return maxW * maxH
    }
}