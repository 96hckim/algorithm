package basic_part_1.data_structure_200;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Queue_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> queue = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push" -> queue.offer(Integer.parseInt(st.nextToken()));
                case "pop" -> bw.write((queue.isEmpty() ? -1 : queue.poll()) + "\n");
                case "size" -> bw.write(queue.size() + "\n");
                case "empty" -> bw.write((queue.isEmpty() ? 1 : 0) + "\n");
                case "front" -> bw.write((queue.isEmpty() ? -1 : queue.peekFirst()) + "\n");
                case "back" -> bw.write((queue.isEmpty() ? -1 : queue.peekLast()) + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
