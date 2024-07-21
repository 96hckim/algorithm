package Level11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class MyStack<T> {

    ArrayList<T> stack = new ArrayList<>();
    int size = 0;

    void create(int n) {
        this.size = n;
    }

    void push(T item) {
        if (stack.size() >= size) System.out.println("Overflow");
        else stack.add(item);
    }

    void pop() {
        if (stack.isEmpty()) System.out.println("Underflow");
        else stack.remove(stack.size() - 1);
    }

    void top() {
        if (stack.isEmpty()) System.out.println("NULL");
        else System.out.println(stack.get(stack.size() - 1));
    }

}

public class StackImplementation {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        MyStack<Integer> myStack = new MyStack<>();
        myStack.create(n);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int calculation = Integer.parseInt(st.nextToken());

            switch (calculation) {
                case 1:
                    int pushNum = Integer.parseInt(st.nextToken());
                    myStack.push(pushNum);
                    break;
                case 2:
                    myStack.pop();
                    break;
                case 3:
                    myStack.top();
                    break;
            }
        }

        br.close();

    }

}
