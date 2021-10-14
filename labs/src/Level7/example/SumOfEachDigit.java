package Level7.example;

import java.io.*;
import java.util.StringTokenizer;

/**
 * n 의 각 자릿수의 합
 */
public class SumOfEachDigit {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        bw.write(getDigitSum(n) + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static int getDigitSum(int n) {
        if (n / 10 == 0) {
            return n;
        }

        return n % 10 + getDigitSum(n / 10);
    }

}
