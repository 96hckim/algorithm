package Special.migratorybird.partialconcept;

import java.io.*;
import java.util.StringTokenizer;

public class SimplePush {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N;
    private static int[] seq;

    // 입력
    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        seq = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
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
        push();
        for(int num : seq) bw.write(num + " ");
        output();
    }

    private static void push() {
        for (int i = seq.length - 1; i > 0; i--) seq[i] = seq[i - 1];
        seq[0] = 0;
    }

}
