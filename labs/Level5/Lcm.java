package Level5;

import java.io.*;
import java.util.StringTokenizer;

public class Lcm {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long lcm = lcm(a, b);
        bw.write(lcm + "");

        br.close();
        bw.flush();
        bw.close();

    }

    static long gcd(long a, long b) {
        if (a % b == 0) {
            return b;
        }

        return gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

}
