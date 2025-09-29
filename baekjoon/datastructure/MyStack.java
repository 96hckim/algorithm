package datastructure;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

class MyStack<T> {
    private List<T> list = new ArrayList<>();

    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        return list.removeLast();
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
