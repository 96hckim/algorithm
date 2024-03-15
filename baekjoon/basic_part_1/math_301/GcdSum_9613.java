package basic_part_1.math_301;

import java.io.*;
import java.util.StringTokenizer;

public class GcdSum_9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] numbers = new int[n];
            for (int j = 0; j < numbers.length; j++) {
                numbers[j] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            for (int j = 0; j < numbers.length - 1; j++) {
                for (int k = j + 1; k < numbers.length; k++) {
                    sum += gcd(numbers[j], numbers[k]);
                }
            }

            bw.write(sum + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
