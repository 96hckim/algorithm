package level10;

import java.io.*;

public class NNTable {

    private static long n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Long.parseLong(br.readLine());
        long k = Long.parseLong(br.readLine());

        long start = 1;
        long end = n * n + 1;

        while (start + 1 < end) {

            long mid = (start + end) / 2;

            long number = getNumber(mid);

            if (number < k) start = mid;
            else if (number > k) end = mid;
            else {
                System.out.println(mid);
                return;
            }

        }

        bw.write(start + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static long getNumber(long x) {

        long result = 1;

        for (long i = 1; i <= n; i++) {
            if (i * n < x) result += n;
            else {
                if (x % i == 0) result += x / i - 1;
                else result += x / i;
            }
        }

        return result;

    }

}
