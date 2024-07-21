package Test;

import java.io.*;
import java.util.StringTokenizer;

public class ButtonPressE {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N;
    private static int[][] score;

    private static int max = Integer.MIN_VALUE;

    // 입력
    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        score = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            score[i][0] = red;
            score[i][1] = green;
            score[i][2] = blue;
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
        recursive(0, -1, 0);
        bw.write(max + "");
        output();
    }

    private static void recursive(int x, int prev, int sum) {
        if (x == N) {
            if (max < sum) max = sum;
        } else {
            for (int i = 0; i < 3; i++) {
                if (i == prev) continue;
                recursive(x + 1, i, sum + score[x][i]);
            }
        }
    }

}
