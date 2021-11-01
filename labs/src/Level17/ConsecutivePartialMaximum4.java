package Level17;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ConsecutivePartialMaximum4 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (i == 0) {
                dp[i] = num;
            } else {
                dp[i] = Math.max(dp[i - 1] + num, num);
            }
        }

        int max = Arrays.stream(dp).max().orElse(0);

        bw.write(max + "");

        br.close();
        bw.flush();
        bw.close();

    }

}
