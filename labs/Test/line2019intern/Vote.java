package Test.line2019intern;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Vote {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N;

    private static int start;
    private static int end;

    private static PriorityQueue<Integer> startQueue;
    private static PriorityQueue<Integer> endQueue;

    // 입력
    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        start = Integer.MAX_VALUE;
        end = Integer.MIN_VALUE;

        startQueue = new PriorityQueue<>();
        endQueue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if (start > s) start = s;
            if (end < e) end = e;
            startQueue.add(s);
            endQueue.add(e);
        }
    }

    // 출력
    private static void output() throws IOException {
        br.close();
        bw.flush();
        bw.close();
    }

    // 메인
    public static void main(String[] args) throws IOException {
        input();

        int max = 1;
        int booth = 0;

        for (int i = start; i <= end; i++) {
            while (!startQueue.isEmpty() && i >= startQueue.peek()) {
                startQueue.poll();
                booth++;
            }

            while (!endQueue.isEmpty() && i >= endQueue.peek()) {
                endQueue.poll();
                booth--;
            }

            if (max < booth) max = booth;
        }

        bw.write(max + "");

        output();
    }

}
