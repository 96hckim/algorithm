package Test;

import java.io.*;
import java.util.StringTokenizer;

public class Tetris {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int R;
    private static int C;
    private static int[][] map;

    private static int X = 0;
    private static int Y = 0;

    // 입력
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[R + 1][C + 1];

        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
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
        check();
        bw.write(X + " " + Y);
        output();
    }

    private static void check() {
        for (int i = 1; i <= C; i++) {
            int score = 0;

            for (int j = 1; j <= R; j++) {
                if (map[j][i] == 0) {
                    if (j == R) score = getScore(j + 1, i);
                } else {
                    if (j > 4) score = getScore(j, i);
                    break;
                }
            }

            if (Y < score) {
                X = i;
                Y = score;
            }
        }
    }

    private static int getScore(int y, int x) {
        int score = 0;
        int[][] tetris = new int[R + 1][C + 1];

        for (int i = 1; i <= R; i++) {
            tetris[i] = map[i].clone();
        }

        for (int i = 0; i < 4; i++) {
            tetris[--y][x] = 1;
        }

        for (int i = 1; i <= R; i++) {
            boolean isHorizontal = true;

            for (int j = 1; j <= C; j++) {
                if (tetris[i][j] == 0) {
                    isHorizontal = false;
                    break;
                }
            }

            if (isHorizontal) score++;
        }

        return score;
    }

}
