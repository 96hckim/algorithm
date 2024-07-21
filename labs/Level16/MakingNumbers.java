package Level16;

import java.io.*;

public class MakingNumbers {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = 3;
        long[] arr = new long[n + 1];

        arr[1] = 1;
        long sum = 0;

        for (int i = 2; i <= m; i++) {
            sum += arr[i - 1];
            arr[i] = sum + 1;
        }

        for (int i = m + 1; i <= n; i++) {
            sum = 0;

            for (int j = i - m; j <= i - 1; j++) {
                sum += arr[j];
                sum %= 1000007;
            }

            arr[i] = sum;
        }

        long result = arr[n];

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();

    }

}
