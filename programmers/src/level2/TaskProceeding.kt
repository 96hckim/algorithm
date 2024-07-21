package level2

fun main(args: Array<String>) = with(TaskProceeding()) {
    val plans1 = arrayOf(
        arrayOf("korean", "11:40", "30"),
        arrayOf("english", "12:10", "20"),
        arrayOf("math", "12:30", "40")
    )
    println(solution(plans1).contentToString()) // ["korean", "english", "math"]

    val plans2 = arrayOf(
        arrayOf("science", "12:40", "50"),
        arrayOf("music", "12:20", "40"),
        arrayOf("history", "14:00", "30"),
        arrayOf("computer", "12:30", "100")
    )
    println(solution(plans2).contentToString()) // ["science", "history", "computer", "music"]

    val plans3 = arrayOf(
        arrayOf("aaa", "12:00", "20"),
        arrayOf("bbb", "12:10", "30"),
        arrayOf("ccc", "12:40", "10")
    )
    println(solution(plans3).contentToString()) // ["bbb", "ccc", "aaa"]
}

class TaskProceeding {
    data class Task(val name: String, var startTime: Int, var duration: Int)

    fun solution(plans: Array<Array<String>>): Array<String> {
        val tasks = plans.map { (name, start, duration) ->
            val (hours, minutes) = start.split(":").map { it.toInt() }
            Task(name, hours * 60 + minutes, duration.toInt())
        }.sortedBy { it.startTime }

        val completedTasks = mutableListOf<String>()
        val pausedTasks = mutableListOf<Task>()

        for (i in 0 until tasks.lastIndex) {
            val currentTask = tasks[i]
            val nextTask = tasks[i + 1]

            var interval = nextTask.startTime - currentTask.startTime
            if (currentTask.duration <= interval) {
                completedTasks.add(currentTask.name)
                interval -= currentTask.duration
                while (pausedTasks.isNotEmpty() && interval > 0) {
                    val pausedTask = pausedTasks.last()
                    if (pausedTask.duration <= interval) {
                        interval -= pausedTask.duration
                        pausedTasks.removeLast()
                        completedTasks.add(pausedTask.name)
                    } else {
                        pausedTask.duration -= interval
                        interval = 0
                    }
                }
            } else {
                currentTask.duration -= interval
                pausedTasks.add(currentTask)
            }
        }

        completedTasks.add(tasks.last().name)
        completedTasks.addAll(pausedTasks.reversed().map { it.name })

        return completedTasks.toTypedArray()
    }
}