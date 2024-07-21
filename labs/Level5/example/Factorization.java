package Level5.example;

import java.io.*;

/**
 * 숫자 N을 소수의 곱으로 나타냄 (소인수 분해)
 */
public class Factorization {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for (int i = 2; num > 1; ) {
            if (num % i == 0) {
                bw.write(i + " ");
                num /= i;
            } else {
                i++;
            }
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
