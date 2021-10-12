package Level5;

import java.io.*;

public class Fibonacci {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.write(fibonacci(n) + "");

        br.close();
        bw.flush();
        bw.close();

    }

    static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int a = 0;
        int b = 1;
        int sum = 1;

        for (int i = 0; i < n - 2; i++) {
            a = b;
            b = sum;
            sum = a + b;
        }

        return sum;
    }

}
