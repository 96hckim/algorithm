package basic_part_1.data_structure_200;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class StackSequence_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        ArrayList<String> commands = new ArrayList<>(n);
        Stack<Integer> stack = new Stack<>();
        int index = 1;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            for (; index <= num; index++) {
                stack.push(index);
                commands.add("+\n");
            }

            if (stack.peek() == num) {
                stack.pop();
                commands.add("-\n");
            } else {
                commands.clear();
                commands.add("NO");
                break;
            }
        }

        for (String command : commands) {
            bw.write(command);
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
