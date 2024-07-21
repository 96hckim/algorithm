package Level16;

import java.io.*;

public class SumOfSquares {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] squares = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            squares[i] = i;

            for (int j = 2; j * j <= i; j++) {
                squares[i] = Math.min(squares[i], squares[i - (j * j)] + 1);
            }
        }

        bw.write(squares[n] + "");

        br.close();
        bw.flush();
        bw.close();

    }

}
