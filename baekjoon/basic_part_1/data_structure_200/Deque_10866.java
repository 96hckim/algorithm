package basic_part_1.data_structure_200;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Deque_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push_front" -> deque.addFirst(Integer.parseInt(st.nextToken()));
                case "push_back" -> deque.addLast(Integer.parseInt(st.nextToken()));
                case "pop_front" -> bw.write((deque.isEmpty() ? -1 : deque.removeFirst()) + "\n");
                case "pop_back" -> bw.write((deque.isEmpty() ? -1 : deque.removeLast()) + "\n");
                case "size" -> bw.write(deque.size() + "\n");
                case "empty" -> bw.write((deque.isEmpty() ? 1 : 0) + "\n");
                case "front" -> bw.write((deque.isEmpty() ? -1 : deque.getFirst()) + "\n");
                case "back" -> bw.write((deque.isEmpty() ? -1 : deque.getLast()) + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
