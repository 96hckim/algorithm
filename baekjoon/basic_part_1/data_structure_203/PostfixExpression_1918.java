package basic_part_1.data_structure_203;

import java.io.*;
import java.util.Stack;

public class PostfixExpression_1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            switch (c) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                        bw.write(stack.pop());
                    }
                    stack.add(c);
                    break;
                case '(':
                    stack.add(c);
                    break;
                case ')':
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        bw.write(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    bw.write(c);
            }
        }

        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }

        br.close();
        bw.flush();
        bw.close();
    }

    // 연산자 별 우선순위 리턴
    public static int priority(char operator) {
        if (operator == '(' || operator == ')') {
            return 0;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return -1;
    }
}
