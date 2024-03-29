package level1

fun main(args: Array<String>) {
    val solution = CardBundle()

    val cards1 = arrayOf("i", "drink", "water")
    val cards2 = arrayOf("want", "to")
    val goal = arrayOf("i", "want", "to", "drink", "water")
    val result1 = "Yes"
    println(solution.solution(cards1, cards2, goal)) // 출력: Yes

    val cards3 = arrayOf("i", "water", "drink")
    val result2 = "No"
    println(solution.solution(cards3, cards2, goal)) // 출력: No
}

class CardBundle {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var cards1Index = 0
        var cards2Index = 0

        var answer = "Yes"

        for (word in goal) {
            if (cards1Index < cards1.size && cards1[cards1Index] == word) {
                cards1Index++
            } else if (cards2Index < cards2.size && cards2[cards2Index] == word) {
                cards2Index++
            } else {
                answer = "No"
            }
        }

        return answer
    }
}
