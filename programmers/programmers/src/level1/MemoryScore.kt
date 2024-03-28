package level1

fun main(args: Array<String>) {
    val solution = MemoryScore()

    val name1 = arrayOf("may", "kein", "kain", "radi")
    val yearning1 = intArrayOf(5, 10, 1, 3)
    val photo1 = arrayOf(arrayOf("may", "kein", "kain", "radi"), arrayOf("may", "kein", "brin", "deny"), arrayOf("kon", "kain", "may", "coni"))
    val result1 = intArrayOf(19, 15, 6)
    println(solution.solution(name1, yearning1, photo1).contentToString())

    val name2 = arrayOf("kali", "mari", "don")
    val yearning2 = intArrayOf(11, 1, 55)
    val photo2 = arrayOf(arrayOf("kali", "mari", "don"), arrayOf("pony", "tom", "teddy"), arrayOf("con", "mona", "don"))
    val result2 = intArrayOf(67, 0, 55)
    println(solution.solution(name2, yearning2, photo2).contentToString())

    val name3 = arrayOf("may", "kein", "kain", "radi")
    val yearning3 = intArrayOf(5, 10, 1, 3)
    val photo3 = arrayOf(arrayOf("may"), arrayOf("kein", "deny", "may"), arrayOf("kon", "coni"))
    val result3 = intArrayOf(5, 15, 0)
    println(solution.solution(name3, yearning3, photo3).contentToString())
}

class MemoryScore {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        val yearningMap = name.zip(yearning.toTypedArray()).toMap()

        val answer = IntArray(photo.size) { index ->
            photo[index].sumOf { yearningMap.getOrDefault(it, 0) }
        }

        return answer
    }
}