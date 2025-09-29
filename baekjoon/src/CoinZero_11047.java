package src;

import java.io.*;
import java.util.StringTokenizer;

public class CoinZero_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            int coin = coins[i];
            if (coin <= K) {
                count += K / coin;
                K %= coin;
            }
        }

        bw.write(String.valueOf(count));

        bw.flush();
        br.close();
        bw.close();
    }
}
