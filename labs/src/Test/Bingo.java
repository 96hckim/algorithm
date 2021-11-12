package Test;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Bingo {

    private static class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static final int[][] bingo = new int[5][5];
    private static final int[][] calls = new int[5][5];
    private static final HashMap<Integer, Position> position = new HashMap<>();
    private static final boolean[][] check = new boolean[5][5];

    private static int BINGO_LINE = 0;
    private static boolean canLeftDiagonal = false;
    private static boolean canRightDiagonal = false;
    private static int COUNT = 0;

    // 입력
    private static void input() throws IOException {
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
                position.put(bingo[i][j], new Position(i, j));
            }
        }

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                calls[i][j] = Integer.parseInt(st.nextToken());
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
        callingNumber();
        bw.write(COUNT + "");
        output();
    }

    private static void callingNumber() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                COUNT++;
                Position pos = position.get(calls[i][j]);
                check[pos.y][pos.x] = true;
                bingoCheck(pos.y, pos.x);
                if (BINGO_LINE >= 3) return;
            }
        }
    }

    private static void bingoCheck(int i, int j) {

        boolean isClearLine = true;

        // 가로
        for (int k = 0; k < 5; k++) {
            if (!check[i][k]) {
                isClearLine = false;
                break;
            }
        }

        if (isClearLine) BINGO_LINE++;

        isClearLine = true;

        // 세로
        for (int k = 0; k < 5; k++) {
            if (!check[k][j]) {
                isClearLine = false;
                break;
            }
        }

        if (isClearLine) BINGO_LINE++;

        // 좌상 - 우하 대각선
        if (!canLeftDiagonal) {
            if (check[0][0] &&
                    check[1][1] &&
                    check[2][2] &&
                    check[3][3] &&
                    check[4][4]) {
                canLeftDiagonal = true;
                BINGO_LINE++;
            }
        }

        // 우상 - 좌하 대각선
        if (!canRightDiagonal) {
            if (check[4][0] &&
                    check[3][1] &&
                    check[2][2] &&
                    check[1][3] &&
                    check[0][4]) {
                canRightDiagonal = true;
                BINGO_LINE++;
            }
        }

    }

}
