package Level5.example;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 두 수의 최대공약수, 최소공배수 구하기
 */
public class Euclid {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int gcd;
        int lcm = a * b;

        while (true) {
            int r = a % b;

            if (r == 0) {
                gcd = b;
                break;
            }

            a = b;
            b = r;
        }

        lcm /= gcd;

        bw.write("GCD : " + gcd + "\n");
        bw.write("LCM : " + lcm);

        br.close();
        bw.flush();
        bw.close();

    }

}
