package basic_part_1.data_structure_200;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Josephus_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        bw.write("<");

        while (!queue.isEmpty()) {
            for (int i = 0; i < (K - 1); i++) {
                queue.offer(queue.poll());
            }
            bw.write(String.valueOf(queue.poll()));
            if (!queue.isEmpty()) {
                bw.write(", ");
            }
        }

        bw.write(">");

        bw.flush();
        br.close();
        bw.close();
    }
}
