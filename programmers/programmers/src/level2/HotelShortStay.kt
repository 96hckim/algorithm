package level2

fun main(args: Array<String>) {
    val solution = HotelShortStay()

    val bookTimes1 = arrayOf(
        arrayOf("15:00", "17:00"),
        arrayOf("16:40", "18:20"),
        arrayOf("14:20", "15:20"),
        arrayOf("14:10", "19:20"),
        arrayOf("18:20", "21:20")
    )
    println("Result 1: ${solution.solution(bookTimes1)}") // 3

    val bookTimes2 = arrayOf(
        arrayOf("09:10", "10:10"),
        arrayOf("10:20", "12:20")
    )
    println("Result 2: ${solution.solution(bookTimes2)}") // 1

    val bookTimes3 = arrayOf(
        arrayOf("10:20", "12:30"),
        arrayOf("10:20", "12:30"),
        arrayOf("10:20", "12:30")
    )
    println("Result 3: ${solution.solution(bookTimes3)}") // 3
}

class HotelShortStay {
    fun solution(book_time: Array<Array<String>>): Int {
        // 예약 시간을 분 단위의 Int 형으로 변환합니다.
        val timeIntervals = book_time.map { (start, end) ->
            val startTime = start.split(":").let { it[0].toInt() * 60 + it[1].toInt() }
            val endTime = end.split(":").let { it[0].toInt() * 60 + it[1].toInt() } + 10 // 청소 시간을 고려하여 10분 추가
            Pair(startTime, endTime)
        }.sortedWith(compareBy({ it.first }, { it.second }))

        // 각 예약 시간을 방별로 할당합니다.
        val rooms = mutableListOf<Int>()

        for ((start, end) in timeIntervals) {
            var assigned = false
            // 이미 할당된 방 중 사용 가능한 방이 있는지 확인합니다.
            for (i in 0 until rooms.size) {
                if (start >= rooms[i]) {
                    // 사용 가능한 방이 있으면 해당 방에 예약을 할당하고 종료 시간을 업데이트합니다.
                    rooms[i] = end
                    assigned = true
                    break
                }
            }
            // 새 방이 필요한 경우 방을 추가합니다.
            if (!assigned) {
                rooms.add(end)
            }
        }

        // 필요한 방의 수를 반환합니다.
        return rooms.size
    }
}