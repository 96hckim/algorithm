package level1

fun main(args: Array<String>) {
    val solution = DuoCipher()

    val s = "aukks"
    val skip = "wbqd"
    val index = 5
    println(solution.solution(s, skip, index)) // "happy"
}

class DuoCipher {
    fun solution(s: String, skip: String, index: Int): String {
        val skipSet = skip.toSet()

        val answer = StringBuilder()

        for (c in s) {
            var currentChar = c
            var count = 0

            while (count < index) {
                var nextChar = currentChar + 1
                if (nextChar > 'z') {
                    nextChar = 'a'
                }
                if (!skipSet.contains(nextChar)) {
                    count++
                }
                currentChar = nextChar
            }

            answer.append(currentChar)
        }

        return answer.toString()
    }
}
