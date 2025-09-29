package basic_part_1.math_300;

import java.io.*;
import java.util.StringTokenizer;

public class GcdLcm_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int gcd = getGCD(a, b);
        int lcm = (a * b) / gcd;

        bw.write(gcd + "\n" + lcm);

        bw.flush();
        br.close();
        bw.close();
    }

    // 유클리드 호제법
    private static int getGCD(int x, int y) {
        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}
