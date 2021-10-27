package Level14;

import java.io.*;
import java.util.StringTokenizer;

public class FindAPowerL {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        bw.write(pow(n, m) + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static long pow(long n, long m) {
        if (m == 1) return n;
        if (m % 2 == 0) {
            long temp = pow(n, m / 2);
            return temp * temp % 10007;
        } else {
            long temp = pow(n, (m - 1) / 2);
            return n * temp * temp % 10007;
        }
    }

}
