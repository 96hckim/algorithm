package Special.Slime.inquiry;

import java.io.*;
import java.util.StringTokenizer;

public class SlimeA {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N;
    private static int M;
    private static int X;
    private static int Y;
    private static int[][] field;

    private static int SUM;
    private static int COUNT;

    // 입력
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        field = new int[N][M];
        SUM = 0;
        COUNT = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
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
        inquiry();
        if (COUNT == 0) bw.write(-1 + "");
        else bw.write(SUM / COUNT + "");
        output();
    }

    private static void inquiry() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (field[i][j] >= X && field[i][j] <= Y) {
                    SUM += field[i][j];
                    COUNT++;
                }
            }
        }
    }

}
