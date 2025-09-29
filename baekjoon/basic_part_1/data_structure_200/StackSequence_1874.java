package basic_part_1.data_structure_200;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackSequence_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int current = 1;
        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());

            while (current <= target) {
                stack.push(current++);
                result.add("+\n");
            }

            if (stack.peek() == target) {
                stack.pop();
                result.add("-\n");
            } else {
                result.clear();
                result.add("NO");
                break;
            }
        }

        for (String op : result) {
            bw.write(op);
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
