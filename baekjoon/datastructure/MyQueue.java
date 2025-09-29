package datastructure;

import java.util.NoSuchElementException;

class MyQueue<T> {
    private Object[] arr;
    private int front, rear, size, capacity;

    public MyQueue(int capacity) {
        this.capacity = capacity;
        arr = new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void offer(T item) {
        if (size == capacity) throw new RuntimeException("Queue is full");
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T poll() {
        if (isEmpty()) throw new NoSuchElementException();
        T item = (T) arr[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return (T) arr[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
