package Level13.example;

import java.io.*;

class MyPriorityQueue {

    int[] priorityQueue;
    int index = 0;

    public MyPriorityQueue(int length) {
        priorityQueue = new int[length];
    }

    void push(int num) {
        if (index == priorityQueue.length) return;
        priorityQueue[index++] = num;
    }

    void pop() {

        if (priorityQueue.length == 0) return;

        int maxValue = 0;
        int maxIndex = -1;

        for (int i = 0; i < priorityQueue.length; i++) {
            if (priorityQueue[i] > maxValue) {
                maxValue = priorityQueue[i];
                maxIndex = i;
            }
        }

        for (int i = maxIndex; i < priorityQueue.length - 1; i++) {
            priorityQueue[i] = priorityQueue[i + 1];
        }

        index--;

    }

    int top() {

        if (priorityQueue.length == 0) return -1;

        int maxValue = 0;

        for (int i = 0; i < index; i++) {
            if (priorityQueue[i] > maxValue) {
                maxValue = priorityQueue[i];
            }
        }

        return maxValue;

    }

}

public class PriorityQueueImplementation {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        MyPriorityQueue myPriorityQueue = new MyPriorityQueue(4);

        myPriorityQueue.push(1);
        myPriorityQueue.push(8);
        myPriorityQueue.push(7);
        myPriorityQueue.push(5);

        bw.write(myPriorityQueue.top() + "\n"); // 8

        myPriorityQueue.pop();

        bw.write(myPriorityQueue.top() + "\n"); // 7

        myPriorityQueue.pop();

        bw.write(myPriorityQueue.top() + "\n"); // 5

        myPriorityQueue.pop();

        bw.write(myPriorityQueue.top() + "\n"); // 1

        br.close();
        bw.flush();
        bw.close();

    }

}
