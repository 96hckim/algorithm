package basic_part_1.data_structure_203;

import java.io.*;
import java.util.Stack;

public class PostfixExpression2_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        char[] input = br.readLine().toCharArray();

        double[] numbers = new double[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();

        for (char c : input) {
            if (c >= 'A' && c <= 'Z') {
                int index = c - 'A';
                double number = numbers[index];
                stack.push(number);
            } else {
                double first = stack.pop();
                double second = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(second + first);
                        break;
                    case '-':
                        stack.push(second - first);
                        break;
                    case '/':
                        stack.push(second / first);
                        break;
                    case '*':
                        stack.push(second * first);
                        break;
                }
            }
        }

        bw.write(String.format("%.2f", stack.pop()));

        br.close();
        bw.flush();
        bw.close();
    }
}
