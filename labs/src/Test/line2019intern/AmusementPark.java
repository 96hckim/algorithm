package Test.line2019intern;

import java.io.*;
import java.util.StringTokenizer;

public class AmusementPark {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N;
    private static int K;

    private static int[] guests;
    private static int[] sum;
    private static int RESULT;

    // 입력
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        guests = new int[N];
        sum = new int[K];
        RESULT = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            guests[i] = Integer.parseInt(br.readLine());
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

        for (int guest : guests) {
            int min = Integer.MAX_VALUE;
            int index = -1;

            for (int i = 0; i < sum.length; i++) {
                if (min > sum[i]) {
                    min = sum[i];
                    index = i;
                }
            }

            sum[index] += guest;
        }

        for (int num : sum) {
            if (RESULT < num) RESULT = num;
        }

        bw.write(RESULT + "");
        output();
    }

}
