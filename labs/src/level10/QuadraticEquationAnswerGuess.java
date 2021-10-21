package level10;

import java.io.*;

public class QuadraticEquationAnswerGuess {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long a = Long.parseLong(br.readLine());

        long start = 0;
        long end = (long) Math.sqrt(1000000000000000000L);
        long answer = -1;

        while (start + 1 < end) {
            long mid = (start + end) / 2;
            long check = check(mid, a);

            if (check == 1) end = mid;
            else if (check == -1) start = mid;
            else {
                answer = mid;
                break;
            }
        }

        if (answer == -1) answer = start;

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static int check(long num, long a) {

        long result = num * num + num;
        return Long.compare(result, a);

    }

}