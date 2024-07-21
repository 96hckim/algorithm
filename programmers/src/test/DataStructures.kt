package test

class Stack<T> {
    private val elements: MutableList<T> = mutableListOf()

    fun push(item: T) {
        elements.add(item)
    }

    fun pop(): T? = elements.removeLastOrNull()

    fun peek(): T? = elements.lastOrNull()

    fun isEmpty() = elements.isEmpty()

    fun size() = elements.size
}

class Queue<T> {
    private val elements: MutableList<T> = mutableListOf()

    fun enqueue(item: T) {
        elements.add(item)
    }

    fun dequeue(): T? = elements.removeFirstOrNull()

    fun peek(): T? = elements.firstOrNull()

    fun isEmpty() = elements.isEmpty()

    fun size() = elements.size
}