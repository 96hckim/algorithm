package level1

fun main(args: Array<String>) {
    val solution = MostGiftCount()

    val friends1 = arrayOf("muzi", "ryan", "frodo", "neo")
    val gifts1 = arrayOf("muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi")
    println("case1: ${solution.solution(friends1, gifts1)}") // 2 출력

    val friends2 = arrayOf("joy", "brad", "alessandro", "conan", "david")
    val gifts2 = arrayOf("alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david")
    println("case2: ${solution.solution(friends2, gifts2)}") // 4 출력

    val friends3 = arrayOf("a", "b", "c")
    val gifts3 = arrayOf("a b", "b a", "c a", "a c", "a c", "c a")
    println("case3: ${solution.solution(friends3, gifts3)}") // 0 출력
}

class MostGiftCount {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        val friendsMap = friends.associateWith { mutableMapOf<String, Int>() }
        val giftIndexMap = friends.associateWith { 0 }.toMutableMap()

        for (gift in gifts) {
            val (sender, receiver) = gift.split(" ")

            val senderMap = friendsMap.getOrDefault(sender, mutableMapOf())
            val receiverMap = friendsMap.getOrDefault(receiver, mutableMapOf())

            senderMap[receiver] = senderMap.getOrDefault(receiver, 0) + 1
            receiverMap[receiver] = receiverMap.getOrDefault(sender, 0) - 1

            giftIndexMap[sender] = giftIndexMap.getOrDefault(sender, 0) + 1
            giftIndexMap[receiver] = giftIndexMap.getOrDefault(receiver, 0) - 1
        }

        val resultMap = friends.associateWith { 0 }.toMutableMap()

        for (i in friends.indices) {
            for (j in i + 1 until friends.size) {
                val a = friends[i]
                val b = friends[j]

                val countA = friendsMap.getOrDefault(a, mutableMapOf()).getOrDefault(b, 0)
                val countB = friendsMap.getOrDefault(b, mutableMapOf()).getOrDefault(a, 0)

                if (countA > countB) {
                    resultMap[a] = resultMap.getOrDefault(a, 0) + 1
                } else if (countA < countB) {
                    resultMap[b] = resultMap.getOrDefault(b, 0) + 1
                } else {
                    val indexA = giftIndexMap.getOrDefault(a, 0)
                    val indexB = giftIndexMap.getOrDefault(b, 0)

                    if (indexA > indexB) {
                        resultMap[a] = resultMap.getOrDefault(a, 0) + 1
                    } else if (indexA < indexB) {
                        resultMap[b] = resultMap.getOrDefault(b, 0) + 1
                    }
                }
            }
        }

        return resultMap.values.maxOrNull() ?: 0
    }
}