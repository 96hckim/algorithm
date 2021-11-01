package Level16;

import java.io.*;

public class NumberOfRectArrangement {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if (n < 3) {
            bw.write(n + "");
        } else {
            int a = 1;
            int b = 2;
            int sum = 3;

            for (int i = 0; i < n - 3; i++) {
                a = b;
                b = sum;
                sum = (a + b) % 1000007;
            }

            bw.write(sum + "");
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
