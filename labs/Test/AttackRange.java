package Test;

import java.io.*;
import java.util.StringTokenizer;

public class AttackRange {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N;
    private static int X;
    private static int Y;
    private static int R;
    private static int[][] map;

    // 입력
    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
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

        int startX = Math.max(X - R, 1);
        int startY = Math.max(Y - R, 1);

        int endX = Math.min(X + R, N);
        int endY = Math.min(Y + R, N);

        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                int distance = Math.abs(X - i) + Math.abs(Y - j);
                if (distance <= R) map[i][j] = distance;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == X && j == Y) bw.write("x ");
                else bw.write(map[i][j] + " ");
            }
            bw.newLine();
        }

        output();
    }

}
