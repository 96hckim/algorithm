package level1

fun main(args: Array<String>) {
    val solution = RunningRace()

    val players = arrayOf("mumu", "soe", "poe", "kai", "mine")
    val callings = arrayOf("kai", "kai", "mine", "mine")
    println(solution.solution(players, callings).contentToString()) // ["mumu", "kai", "mine", "soe", "poe"]
}

class RunningRace {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val playerMap = mutableMapOf<String, Int>()

        players.forEachIndexed { index, player ->
            playerMap[player] = index
        }

        for (callingPlayer in callings) {
            val callingIndex = playerMap[callingPlayer] ?: continue
            if (callingIndex > 0) {
                val frontIndex = callingIndex - 1
                val frontPlayer = players[frontIndex]

                players[callingIndex] = frontPlayer
                players[frontIndex] = callingPlayer

                playerMap[frontPlayer] = callingIndex
                playerMap[callingPlayer] = frontIndex
            }
        }

        return players
    }
}