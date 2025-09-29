package datastructure;

import java.util.LinkedList;
import java.util.NoSuchElementException;

class MyDeque<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void addFirst(T item) {
        list.addFirst(item);
    }

    public void addLast(T item) {
        list.addLast(item);
    }

    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        return list.removeFirst();
    }

    public T removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        return list.removeLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
