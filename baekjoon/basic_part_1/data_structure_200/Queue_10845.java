package basic_part_1.data_structure_200;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Queue_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        LinkedList<String> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    queue.add(st.nextToken());
                    break;
                case "pop":
                    if (queue.isEmpty()) {
                        bw.write("-1");
                    } else {
                        bw.write(queue.removeFirst());
                    }
                    bw.newLine();
                    break;
                case "size":
                    bw.write(queue.size() + "\n");
                    break;
                case "empty":
                    bw.write(queue.isEmpty() ? "1" : "0");
                    bw.newLine();
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        bw.write("-1");
                    } else {
                        bw.write(queue.getFirst());
                    }
                    bw.newLine();
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        bw.write("-1");
                    } else {
                        bw.write(queue.getLast());
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
