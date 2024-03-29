package level1

fun main(args: Array<String>) {
    val solution = PersonalDataCollectionValidity()

    val today1 = "2022.05.19"
    val terms1 = arrayOf("A 6", "B 12", "C 3")
    val privacies1 = arrayOf("2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C")
    val result1 = intArrayOf(1, 3)
    println("Test 1 Result: ${solution.solution(today1, terms1, privacies1).contentToString()}")

    val today2 = "2020.01.01"
    val terms2 = arrayOf("Z 3", "D 5")
    val privacies2 = arrayOf("2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z")
    val result2 = intArrayOf(1, 4, 5)
    println("Test 2 Result: ${solution.solution(today2, terms2, privacies2).contentToString()}")
}

class PersonalDataCollectionValidity {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val (year, month, day) = today.split(".").map { it.toInt() }

        val termMap = terms.associate { term ->
            val (name, days) = term.split(" ")
            name to days.toInt()
        }

        return privacies.mapIndexedNotNull { index, privacy ->
            val (regDate, term) = privacy.split(" ")

            val (regYear, regMoth, regDay) = regDate.split(".").map { it.toInt() }
            val termDays = termMap.getOrDefault(term, 0)

            val plusYear = termDays / 12
            val plusMonth = termDays % 12

            var maxYear = regYear + plusYear

            var maxMonth = regMoth + plusMonth
            if (maxMonth > 12) {
                maxMonth -= 12
                maxYear += 1
            }

            var maxDay = regDay - 1
            if (maxDay == 0) {
                maxDay = 28
                maxMonth -= 1
                if (maxMonth == 0) {
                    maxMonth = 12
                    maxYear -= 1
                }
            }

            if (year > maxYear || (year == maxYear && (month > maxMonth || (month == maxMonth && day > maxDay)))) {
                index + 1
            } else {
                null
            }
        }.toIntArray()
    }
}
