package kit.dynamic_programming

fun main(args: Array<String>) = with(ExpressWithN()) {
    val N1 = 5
    val number1 = 12
    println("Return: ${solution(N1, number1)}") // 4

    val N2 = 2
    val number2 = 11
    println("Return: ${solution(N2, number2)}") // 3
}

class ExpressWithN {
    fun solution(N: Int, number: Int): Int {
        val dp = MutableList(9) { mutableSetOf<Int>() }

        for (i in 1..8) {
            val repeatedN = N.toString().repeat(i).toInt()
            dp[i].add(repeatedN)

            for (j in 1 until i) {
                for (x in dp[j]) {
                    for (y in dp[i - j]) {
                        dp[i].add(x + y)
                        dp[i].add(x - y)
                        dp[i].add(x * y)
                        if (y != 0) dp[i].add(x / y)
                    }
                }
            }
            if (number in dp[i]) return i
        }

        return -1
    }
}