package basic_part_2.brute_force_530;

import java.io.*;

public class Adding123_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n + 1];

            // 초기값 설정
            dp[0] = 1;

            // 다이나믹 프로그래밍을 통한 경우의 수 계산
            for (int i = 1; i <= n; i++) {
                if (i - 1 >= 0)
                    dp[i] += dp[i - 1];
                if (i - 2 >= 0)
                    dp[i] += dp[i - 2];
                if (i - 3 >= 0)
                    dp[i] += dp[i - 3];
            }

            bw.write(dp[n] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
