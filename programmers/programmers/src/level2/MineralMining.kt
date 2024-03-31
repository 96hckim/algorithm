package level2

fun main(args: Array<String>) = with(MineralMining()) {
    val picks1 = intArrayOf(1, 3, 2)
    val minerals1 = arrayOf("diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone")
    println("Result 1: ${solution(picks1, minerals1)}") // 12

    val picks2 = intArrayOf(0, 1, 1)
    val minerals2 = arrayOf("diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond")
    println("Result 2: ${solution(picks2, minerals2)}") // 50
}

class MineralMining {
    enum class Pick(val fatigue: Map<String, Int>) {
        DIAMOND(mapOf("diamond" to 1, "iron" to 1, "stone" to 1)),
        IRON(mapOf("diamond" to 5, "iron" to 1, "stone" to 1)),
        STONE(mapOf("diamond" to 25, "iron" to 5, "stone" to 1))
    }

    fun solution(picks: IntArray, minerals: Array<String>): Int {
        val pickList = picks.zip(listOf(Pick.DIAMOND, Pick.IRON, Pick.STONE))
            .flatMap { (count, pick) -> List(count) { pick } }
        val mineralList = minerals.take(pickList.size * 5)
        var minFatigue = Int.MAX_VALUE

        fun dfs(index: Int, fatigue: Int, remainingPicks: List<Pick>) {
            if (index >= mineralList.size) {
                minFatigue = minOf(minFatigue, fatigue)
                return
            }
            if (fatigue >= minFatigue || remainingPicks.isEmpty()) return

            remainingPicks.distinct().forEach { pick ->
                val nextFatigue = fatigue + (index until index + 5).sumOf { j ->
                    if (j < mineralList.size) pick.fatigue[mineralList[j]] ?: 0 else 0
                }
                dfs(index + 5, nextFatigue, remainingPicks - pick)
            }
        }

        dfs(0, 0, pickList)
        return minFatigue
    }
}