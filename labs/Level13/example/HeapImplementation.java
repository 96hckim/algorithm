package Level13.example;

import java.util.ArrayList;
import java.util.Collections;

class MyHeap {

    ArrayList<Integer> heap = new ArrayList<>();

    public MyHeap() {
        heap.add(null);
    }

    void push(int num) {

        heap.add(num);
        int index = heap.size() - 1;

        while (index / 2 > 0) {
            if (num < heap.get(index / 2)) {
                Collections.swap(heap, index, index / 2);
                index /= 2;
            } else {
                break;
            }
        }

    }

    Integer pop() {

        if (heap.size() <= 1) return null;

        int returnValue = heap.get(1);

        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        if (heap.size() <= 1) return returnValue;

        int preIndex = -1;
        int currentIndex = 1;

        while (preIndex != currentIndex) {

            preIndex = currentIndex;

            int currentValue = heap.get(currentIndex);

            int leftIndex = currentIndex * 2;
            int rightIndex = currentIndex * 2 + 1;

            if (rightIndex < heap.size()) {

                if (heap.get(leftIndex) < heap.get(rightIndex)) {
                    if (heap.get(leftIndex) < currentValue) {
                        Collections.swap(heap, currentIndex, leftIndex);
                        currentIndex = leftIndex;
                    }
                } else {
                    if (heap.get(rightIndex) < currentValue) {
                        Collections.swap(heap, currentIndex, rightIndex);
                        currentIndex = rightIndex;
                    }
                }

            } else {

                if (leftIndex < heap.size()) {

                    if (heap.get(leftIndex) < currentValue) {
                        Collections.swap(heap, currentIndex, leftIndex);
                        currentIndex = leftIndex;
                    }

                }

            }

        }

        return returnValue;

    }

    Integer top() {
        if (heap.size() <= 1) return null;
        else return heap.get(1);
    }

}

public class HeapImplementation {

    public static void main(String[] args) {

        MyHeap myHeap = new MyHeap();

        myHeap.push(3);
        myHeap.push(1);
        myHeap.push(2);

        System.out.println(myHeap.pop());
        System.out.println(myHeap.pop());
        System.out.println(myHeap.pop());

    }

}
