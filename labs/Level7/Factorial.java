package Level7;

import java.io.*;

public class Factorial {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.write(getFactorial(n) + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static int getFactorial(int n) {
        if (n == 1) {
            return n;
        }

        return n * getFactorial(n - 1);
    }

}
