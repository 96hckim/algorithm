package Test;

import java.io.*;
import java.util.StringTokenizer;

public class Password {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int D;
    private static int K;
    private static int COUNT = 0;

    // 입력
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
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
        recursive(new int[5], 0, 0);
        bw.write(COUNT + "");
        output();
    }

    private static void recursive(int[] arr, int x, int sum) {
        if (x == arr.length) {
            if (sum % K == D) COUNT++;
        } else {
            for (int i = 0; i < 10; i++) {
                arr[x] = i;
                recursive(arr, x + 1, sum + arr[x]);
            }
        }
    }

}
