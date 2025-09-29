package basic_part_1.data_structure_200;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push" -> stack.push(st.nextToken());
                case "pop" -> bw.write((stack.isEmpty() ? -1 : stack.pop()) + "\n");
                case "size" -> bw.write(stack.size() + "\n");
                case "empty" -> bw.write((stack.isEmpty() ? 1 : 0) + "\n");
                case "top" -> bw.write((stack.isEmpty() ? -1 : stack.peek()) + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
