package Test;

import java.io.*;

public class OutputBracket {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N;
    private static final char[] bracket = {'(', ')'};
    private static final int[] score = {1, -1};

    // 입력
    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
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
        recursive(new int[N], 0, 0);
        output();
    }

    private static void recursive(int[] arr, int x, int count) throws IOException {
        if (x == N) {
            if (count == 0) {
                printResult(arr);
            }
        } else {
            for (int i = 0; i < 2; i++) {
                if (count + score[i] < 0) continue;
                arr[x] = i;
                recursive(arr, x + 1, count + score[i]);
            }
        }
    }

    private static void printResult(int[] arr) throws IOException {
        for (int idx : arr) {
            bw.write(bracket[idx] + "");
        }
        bw.newLine();
    }

}
