package src;

import java.io.*;
import java.util.StringTokenizer;

public class WoodCutter_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long[] trees = new long[N];
        st = new StringTokenizer(br.readLine());
        long max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Long.parseLong(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        long left = 0;
        long right = max;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                if (trees[i] > mid) {
                    sum += trees[i] - mid;
                }
            }

            if (sum >= M) {  // 필요한 나무 이상 확보 가능
                answer = mid; // 일단 후보로 저장
                left = mid + 1; // 더 높은 값도 가능한지 확인
            } else {
                right = mid - 1; // 너무 많이 잘라야 해서 높이를 낮춤
            }
        }

        bw.write(String.valueOf(answer));

        bw.flush();
        br.close();
        bw.close();
    }
}
