package Special.alphayut.partialconcept;

import java.io.*;

public class NumberCombination1 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N;

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
        recursive(new int[3], 0);
        output();
    }

    private static void recursive(int[] arr, int x) throws IOException {
        if (x == 3) {
            for (int num : arr) bw.write(num + " ");
            bw.newLine();
        } else {
            for (int i = 1; i <= N; i++) {
                arr[x] = i;
                recursive(arr, x + 1);
            }
        }
    }

}
