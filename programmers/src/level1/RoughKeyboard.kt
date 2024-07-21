package level1

fun main(args: Array<String>) {
    val solution = RoughKeyboard()

    val keymap1 = arrayOf("ABACD", "BCEFD")
    val targets1 = arrayOf("ABCD", "AABB")
    val result1 = intArrayOf(9, 4)
    println(solution.solution(keymap1, targets1).contentToString())

    val keymap2 = arrayOf("AA")
    val targets2 = arrayOf("B")
    val result2 = intArrayOf(-1)
    println(solution.solution(keymap2, targets2).contentToString())

    val keymap3 = arrayOf("AGZ", "BSSS")
    val targets3 = arrayOf("ASA", "BGZ")
    val result3 = intArrayOf(4, 6)
    println(solution.solution(keymap3, targets3).contentToString())
}

class RoughKeyboard {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        val keymapCount = mutableMapOf<Char, Int>()

        keymap.forEach { key ->
            key.forEachIndexed { index, c ->
                keymapCount[c] = minOf(index + 1, keymapCount.getOrDefault(c, Int.MAX_VALUE))
            }
        }

        val answer = IntArray(targets.size) { index ->
            val target = targets[index]
            var count = 0
            for (c in target.toCharArray()) {
                if (keymapCount.containsKey(c)) {
                    count += keymapCount.getOrDefault(c, 0)
                } else {
                    count = -1
                    break
                }
            }
            count
        }

        return answer
    }
}
