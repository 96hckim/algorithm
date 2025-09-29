package src;

import java.io.*;

public class BertrandPostulate_4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 123456 * 2;
        boolean[] isPrime = new boolean[max + 1];

        // 에라토스테네스의 체
        for (int i = 2; i <= max; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int count = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (isPrime[i]) count++;
            }

            bw.write(count + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
