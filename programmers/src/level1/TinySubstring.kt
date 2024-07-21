package level1

fun main(args: Array<String>) {
    val solution = TinySubstring()

    val t1 = "3141592"
    val p1 = "271"
    val result1 = 2
    println("Test 1 Result: ${solution.solution(t1, p1)}")

    val t2 = "500220839878"
    val p2 = "7"
    val result2 = 8
    println("Test 2 Result: ${solution.solution(t2, p2)}")

    val t3 = "10203"
    val p3 = "15"
    val result3 = 3
    println("Test 3 Result: ${solution.solution(t3, p3)}")
}

class TinySubstring {
    fun solution(t: String, p: String): Int {
        return (0..t.length - p.length)
            .map { i -> t.substring(i until i + p.length) }
            .count { sub -> sub <= p }
    }
}
