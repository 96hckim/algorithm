package kit.brute_force

import kotlin.math.sqrt

class PrimeFinder {
    private fun isPrime(number: Int): Boolean {
        if (number < 2) return false
        for (i in 2..sqrt(number.toDouble()).toInt()) {
            if (number % i == 0) return false
        }
        return true
    }

    fun solution(numbers: String): Int {
        val numberSet = mutableSetOf<Int>()

        fun permutation(prefix: String, str: String) {
            if (prefix.isNotEmpty()) numberSet.add(prefix.toInt())

            for (i in str.indices) {
                permutation(prefix + str[i], str.substring(0, i) + str.substring(i + 1, str.length))
            }
        }

        permutation("", numbers)

        return numberSet.count { isPrime(it) }
    }
}