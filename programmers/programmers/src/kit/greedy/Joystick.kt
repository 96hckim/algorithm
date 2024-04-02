package kit.greedy

fun main(args: Array<String>) = with(Joystick()) {
    val name1 = "JEROEN"
    println("Return: ${solution(name1)}") // 56

    val name2 = "JAN"
    println("Return: ${solution(name2)}") // 23
}

class Joystick {
    fun solution(name: String): Int {
        val n = name.length
        var move = n - 1

        fun minMove(index: Int): Int {
            var nextIndex = index + 1
            while (nextIndex < n && name[nextIndex] == 'A') {
                nextIndex++
            }
            return index.coerceAtMost(n - nextIndex) + index + (n - nextIndex)
        }

        var answer = 0
        for (i in name.indices) {
            answer += (name[i] - 'A').coerceAtMost('Z' - name[i] + 1)
            move = move.coerceAtMost(minMove(i))
        }

        return answer + move
    }
}