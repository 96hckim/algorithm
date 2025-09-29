package src;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 인출 시간 오름차순 정렬

        int prefix = 0; // 누적합
        int sum = 0;    // 최종 합
        for (int i = 0; i < n; i++) {
            prefix += arr[i];
            sum += prefix;
        }

        bw.write(String.valueOf(sum));

        bw.flush();
        br.close();
        bw.close();
    }
}
