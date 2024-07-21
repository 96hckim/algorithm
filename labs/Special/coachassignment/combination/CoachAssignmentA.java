package Special.coachassignment.combination;

import java.io.*;
import java.util.StringTokenizer;

public class CoachAssignmentA {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N;
    private static int K;
    private static int T;

    private static int[] students;
    private static int COUNT;
    private static int RESULT;

    // 입력
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        students = new int[N];
        COUNT = 0;
        RESULT = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) students[i] = Integer.parseInt(st.nextToken());
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
        recursive(new int[K], 0, 0);
        bw.write(RESULT + "");
        output();
    }

    private static void recursive(int[] selected, int x, int from) {
        if (x == K) {
            if (T == ++COUNT) for (int i = 0; i < K; i++) RESULT += students[selected[i]];
        } else {
            for (int i = from; i < N; i++) {
                selected[x] = i;
                recursive(selected, x + 1, i + 1);
            }
        }
    }

}
