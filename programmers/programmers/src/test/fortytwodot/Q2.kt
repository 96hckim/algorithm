package test.fortytwodot

/**
 * 정확성 시간 제한 / 메모리 제한
 * 10초 / 2GB
 *
 * 문제 설명
 * 하루 동안 영화 관람객이 예매한 영화들이 무작위로 섞여서 주어집니다. 이때 가장 많이 예매된 순서대로 영화 제목을 정렬하려고 합니다.
 * 관람객이 예매한 영화의 목록 movie가 매개변수로 주어질 때, 가장 많이 예매된 영화 순으로 영화 제목을 정렬하여 return 하도록
 * solution 함수를 완성해 주세요. 예매 수가 같은 영화는 사전 순으로 정렬하세요.
 *
 * 제한사항
 * • 예매된 영화 목록의 길이는 1이상 10,000이하 입니다.
 * • 영화 제목의 길이는 1자 이상 50자 이하이며, 공백없이 모두 소문자입니다.
 * • 같은 제목의 서로 다른 영화는 없다고 가정합니다.
 *
 * 입출력 예
 * movie result
 * ["spy","ray","spy","room","once"," ray","spy","once"] ["spy","once","ray","room"]
 *
 * 입출력 예 설명
 * 입출력 예 #1
 * "spy"가 3번으로 가장 많이 예매되었으며, "once"와 "ray"는 두 번째로 많이 예매되었습니다. 사전 순으로 "once"가 두 번째, "ray"가 세
 * 번째에 오며, "room"이 한 번으로 가장 적게 예매되었습니다.
 */
fun main(args: Array<String>) = with(Q2()) {
    val movie = arrayOf("spy", "ray", "spy", "room", "once", " ray", "spy", "once")
    println("Return: ${solution(movie).joinToString()}") // "spy", "once", "ray", "room"
}

class Q2 {
    fun solution(movie: Array<String>): Array<String> {
        // 영화 제목을 키로, 해당 영화가 예매된 횟수를 값으로 하는 맵 생성
        val movieCountMap = movie.groupBy { it.trim() }.mapValues { it.value.size }

        // 예매 횟수가 많은 순으로 정렬하고, 예매 횟수가 같으면 영화 제목의 사전 순으로 정렬
        return movieCountMap.toList().sortedWith(compareByDescending<Pair<String, Int>> { it.second }.thenBy { it.first }).map { it.first }.toTypedArray()
    }
}