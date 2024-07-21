package Level12;

import java.util.Scanner;

class MyQueue {

    int[] queue;
    int front = 0;
    int rear = 0;

    public MyQueue(int length) {
        queue = new int[length];
    }

    void push(int num) {
        if (rear == queue.length) System.out.println("Overflow");
        else queue[rear++] = num;
    }

    void pop() {
        if (front == rear) System.out.println("Underflow");
        else front++;
    }

    void front() {
        if (front == rear) System.out.println("NULL");
        else System.out.println(queue[front]);
    }

}

public class QueueImplementation {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        MyQueue myQueue = new MyQueue(n);

        for (int i = 0; i < m; i++) {

            int calculation = scan.nextInt();

            switch (calculation) {
                case 1:
                    int num = scan.nextInt();
                    myQueue.push(num);
                    break;
                case 2:
                    myQueue.pop();
                    break;
                case 3:
                    myQueue.front();
                    break;
            }

        }

    }

}
