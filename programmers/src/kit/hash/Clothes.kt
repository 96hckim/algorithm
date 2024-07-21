package kit.hash

fun main(args: Array<String>) {
    val solution = Clothes()

    val clothes1 = arrayOf(
        arrayOf("yellow_hat", "headgear"),
        arrayOf("blue_sunglasses", "eyewear"),
        arrayOf("green_turban", "headgear")
    )
    println("Result 1: ${solution.solution(clothes1)}") // 5

    val clothes2 = arrayOf(
        arrayOf("crow_mask", "face"),
        arrayOf("blue_sunglasses", "face"),
        arrayOf("smoky_makeup", "face")
    )
    println("Result 2: ${solution.solution(clothes2)}") // 3
}

class Clothes {
    fun solution(clothes: Array<Array<String>>): Int {
        val clothesMap = clothes.groupBy { it[1] }.mapValues { it.value.size }

        return clothesMap.values.fold(1) { acc, value -> acc * (value + 1) } - 1
    }
}