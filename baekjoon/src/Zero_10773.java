package src;

import java.io.*;
import java.util.Stack;

public class Zero_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> deque = new Stack<>();

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                deque.pop();
            } else {
                deque.push(num);
            }
        }

        long sum = 0;
        for (Integer val : deque) {
            sum += val;
        }

        bw.write(String.valueOf(sum));

        bw.flush();
        br.close();
        bw.close();
    }
}
