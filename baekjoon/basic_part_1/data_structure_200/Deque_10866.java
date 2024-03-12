package basic_part_1.data_structure_200;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Deque_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Deque<String> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push_front":
                    deque.addFirst(st.nextToken());
                    break;
                case "push_back":
                    deque.addLast(st.nextToken());
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        bw.write("-1");
                    } else {
                        bw.write(deque.removeFirst());
                    }
                    bw.newLine();
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        bw.write("-1");
                    } else {
                        bw.write(deque.removeLast());
                    }
                    bw.newLine();
                    break;
                case "size":
                    bw.write(deque.size() + "\n");
                    break;
                case "empty":
                    bw.write(deque.isEmpty() ? "1" : "0");
                    bw.newLine();
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        bw.write("-1");
                    } else {
                        bw.write(deque.getFirst());
                    }
                    bw.newLine();
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        bw.write("-1");
                    } else {
                        bw.write(deque.getLast());
                    }
                    bw.newLine();
                    break;
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
