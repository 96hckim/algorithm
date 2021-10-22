package level10;

import java.io.*;

public class QuadraticEquationAnswerGuess {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long a = Long.parseLong(br.readLine());

        long start = 0;
        long end = (long) Math.sqrt(1000000000000000000L);

        while (start + 1 < end) {
            long mid = (start + end) / 2;
            long answer = mid * mid + mid;

            if (answer > a) end = mid;
            else if (answer < a) start = mid;
            else {
                System.out.println(mid);
                return;
            }
        }

        bw.write(start + "");

        br.close();
        bw.flush();
        bw.close();


    }

}
