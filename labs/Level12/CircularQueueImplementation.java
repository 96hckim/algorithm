package Level12;

import java.util.ArrayList;
import java.util.Scanner;

class MyCircularQueue<T> {

    private ArrayList<T> queue = new ArrayList<>();
    private int size;

    public MyCircularQueue(int size) {
        this.size = size;
    }

    void push(T item) {
        if (queue.size() >= size) System.out.println("Overflow");
        else queue.add(item);
    }

    void pop() {
        if (queue.isEmpty()) System.out.println("Underflow");
        else queue.remove(0);
    }

    void front() {
        if (queue.isEmpty()) System.out.println("NULL");
        else System.out.println(queue.get(0));
    }

}

public class CircularQueueImplementation {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        MyCircularQueue<Integer> myCircularQueue = new MyCircularQueue<>(n);

        for (int i = 0; i < m; i++) {

            int calculation = scan.nextInt();

            switch (calculation) {
                case 1:
                    int num = scan.nextInt();
                    myCircularQueue.push(num);
                    break;
                case 2:
                    myCircularQueue.pop();
                    break;
                case 3:
                    myCircularQueue.front();
                    break;
            }

        }

    }

}
