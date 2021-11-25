package Test;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Rook {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int[][] chess;
    private static ArrayList<int[]> rooks = new ArrayList<>();

    // 입력
    private static void input() throws IOException {
        chess = new int[8][8];
        rooks = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 8; j++) {
                chess[i][j] = Integer.parseInt(st.nextToken());
                if (chess[i][j] == 2) rooks.add(new int[]{i, j});
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
        int result = 0;
        for (int[] rook : rooks) if (check(rook[0], rook[1])) result = 1;
        bw.write(result + "");
        output();
    }

    private static boolean check(int y, int x) {

        // Top
        for (int i = y - 1; i >= 0; i--) {
            if (chess[i][x] != 0) {
                if (chess[i][x] == 1) return true;
                else break;
            }
        }

        // Bottom
        for (int i = y + 1; i < 8; i++) {
            if (chess[i][x] != 0) {
                if (chess[i][x] == 1) return true;
                else break;
            }
        }

        // Left
        for (int i = x - 1; i >= 0; i--) {
            if (chess[y][i] != 0) {
                if (chess[y][i] == 1) return true;
                else break;
            }
        }

        // Right
        for (int i = x + 1; i < 8; i++) {
            if (chess[y][i] != 0) {
                if (chess[y][i] == 1) return true;
                else break;
            }
        }

        return false;

    }

}
