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

        Queue<Integer> numbers = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            numbers.add(i);
        }

        bw.write("<");
        while (numbers.size() != 1) {
            for (int i = 0; i < K - 1; i++) {
                numbers.offer(numbers.poll());
            }

            bw.write(numbers.poll() + ", ");
        }
        bw.write(numbers.poll() + "");
        bw.write(">");

        br.close();
        bw.flush();
        bw.close();
    }
}
