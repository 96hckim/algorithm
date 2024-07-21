package test.fortytwodot

/**
 * 정확성 시간 제한 메모리 제한
 * 10초 / 2GB
 *
 * 문제 설명
 * 문자열 s가 주어졌을 때 s에 포함된 알파벳 중 홀수개인 알파벳의 개수를 구하려고 합니다. 문자열 s에 포함된 알파벳 중에서 홀수 번 등장
 * 하는 알파벳의 개수를 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * • 문자열 s의 길이는 1 이상 10,000 이하입니다.
 * • 문자열 s는 알파벳 소문자로만 이루어져 있습니다.
 *
 * 입출력 예
 * s result
 * "aabbbccd" 2
 * "abebeaedeac" 3
 *
 * 입출력 예 설명
 * 입출력 예 #1
 * a가 2개, b가 3개, c가 2개, d가 1개이므로 홀수개인 알파벳은 b, d 2개입니다.
 * 입출력 예 #2
 * a가 3개, b가 2개, c가 1개, d가 1개, e가 4개이므로 홀수개인 알파벳은 리 c, d 3개입니다.
 */
fun main(args: Array<String>) = with(Q1()) {
    val s1 = "aabbbccd"
    println("Result: ${solution(s1)}") // 2

    val s2 = "abebeaedeac"
    println("Result: ${solution(s2)}") // 3
}

class Q1 {
    fun solution(s: String): Int {
        val frequencyMap = mutableMapOf<Char, Int>()

        // 각 문자의 빈도수 계산
        for (char in s) {
            frequencyMap[char] = frequencyMap.getOrDefault(char, 0) + 1
        }

        // 홀수 문자의 개수 세기
        var oddCount = 0
        for ((_, count) in frequencyMap) {
            if (count % 2 != 0) oddCount++
        }

        return oddCount
    }
}