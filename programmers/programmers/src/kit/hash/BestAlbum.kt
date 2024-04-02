package kit.hash

fun main(args: Array<String>) = with(BestAlbum()) {
    val genres = arrayOf("classic", "pop", "classic", "classic", "pop")
    val plays = intArrayOf(500, 600, 150, 800, 2500)
    println("Return: ${solution(genres, plays).joinToString(", ")}") // [4, 1, 3, 0]
}

class BestAlbum {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        // 장르별로 (노래 고유 번호, 재생 횟수) 쌍을 매핑
        val genreMap = genres.indices.groupBy { genres[it] }.mapValues { entry ->
            entry.value.map { idx -> Pair(idx, plays[idx]) }
        } // <장르, List<고유 번호, 재생수>>

        // 장르별 총 재생 횟수 계산
        val genrePlayCount = genreMap.mapValues { (_, value) ->
            value.sumOf { it.second }
        }.toList().sortedByDescending { it.second }.toMap()

        // 장르별 상위 2곡 선정
        return genrePlayCount.flatMap { (genre, _) ->
            genreMap[genre]!!.sortedWith(compareByDescending<Pair<Int, Int>> { it.second }.thenBy { it.first }).take(2)
        }.map { it.first }.toIntArray()
    }
}