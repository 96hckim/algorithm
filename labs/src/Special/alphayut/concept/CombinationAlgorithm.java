package Special.alphayut.concept;

import java.io.*;

public class CombinationAlgorithm {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int K;
    private static int count;

    // 입력
    private static void input() throws IOException {
        K = Integer.parseInt(br.readLine());
        count = 0;
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
        recursive(new int[10], 0);
        output();
    }

    private static void recursive(int[] arr, int x) throws IOException {
        if (x == 10) {
            if (++count == K) {
                for (int num : arr) bw.write(num + " ");
            }
        } else {
            for (int i = 1; i <= 4; i++) {
                arr[x] = i;
                recursive(arr, x + 1);
            }
        }
    }

}
