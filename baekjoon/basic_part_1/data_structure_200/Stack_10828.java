package basic_part_1.data_structure_200;

import java.io.*;
import java.util.Stack;

public class Stack_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String command = br.readLine();

            if (command.startsWith("push")) {
                String[] push = command.split(" ");
                stack.push(push[1]);
            } else if (command.startsWith("pop")) {
                if (stack.isEmpty()) {
                    bw.write("-1");
                } else {
                    bw.write(stack.pop());
                }
                bw.newLine();
            } else if (command.startsWith("size")) {
                bw.write(stack.size() + "\n");
            } else if (command.startsWith("empty")) {
                bw.write(stack.isEmpty() ? "1" : "0");
                bw.newLine();
            } else if (command.startsWith("top")) {
                if (stack.isEmpty()) {
                    bw.write("-1");
                } else {
                    bw.write(stack.peek());
                }
                bw.newLine();
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
