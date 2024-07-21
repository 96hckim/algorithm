package Level11;

import java.io.*;
import java.util.Stack;

public class ValueInBracket {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] bracketArray = br.readLine().toCharArray();
        Stack<Integer> myStack = new Stack<>();

        for (char bracket : bracketArray) {

            if (bracket == '(' || bracket == '[') {
                if (bracket == '(') myStack.push(-1);
                else myStack.push(-2);
            } else {
                if (myStack.isEmpty()) {
                    System.out.println("0\n");
                    return;
                }

                int topElement = myStack.peek();

                if (topElement == -1 || topElement == -2) {
                    if (bracket == ')' && topElement == -1) {
                        myStack.pop();
                        myStack.push(2);
                    } else if (bracket == ']' && topElement == -2) {
                        myStack.pop();
                        myStack.push(3);
                    } else {
                        System.out.println("0\n");
                        return;
                    }
                } else {

                    int popValue = myStack.pop();

                    if (myStack.isEmpty()) {
                        System.out.println("0\n");
                        return;
                    }

                    topElement = myStack.peek();

                    if (bracket == ')' && topElement == -1) {
                        myStack.pop();
                        myStack.push(popValue * 2);
                    } else if (bracket == ']' && topElement == -2) {
                        myStack.pop();
                        myStack.push(popValue * 3);
                    } else {
                        System.out.println("0\n");
                        return;
                    }
                }

                if (myStack.size() >= 2) {
                    if (myStack.elementAt(myStack.size() - 1) > 0 && myStack.elementAt(myStack.size() - 2) > 0) {
                        int first = myStack.pop();
                        int second = myStack.pop();
                        myStack.push(first + second);
                    }
                }
            }

        }

        if (myStack.size() == 1 && myStack.peek() > 0) bw.write(myStack.pop() + "");
        else bw.write("0");

        br.close();
        bw.flush();
        bw.close();

    }

}
