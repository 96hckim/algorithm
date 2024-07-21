package kit.sort

fun main(args: Array<String>) = with(LargestNumber()) {
    val numbers1 = intArrayOf(6, 10, 2)
    println("Return: ${solution(numbers1)}") // "6210"

    val numbers2 = intArrayOf(3, 30, 34, 5, 9)
    println("Return: ${solution(numbers2)}") // "9534330"
}

class LargestNumber {
    fun solution(numbers: IntArray): String {
        // 숫자들을 문자열로 변환합니다.
        val numbersAsStrings = numbers.map { it.toString() }

        // 문자열을 재배치하여 만들 수 있는 가장 큰 숫자를 만듭니다.
        val largestNumberString = numbersAsStrings.sortedWith { a, b ->
            (b + a).compareTo(a + b)
        }.joinToString("")

        // 결과가 0으로 시작한다면, 모든 숫자가 0이라는 의미이므로 "0"을 반환합니다.
        return if (largestNumberString.startsWith("0")) "0" else largestNumberString
    }
}