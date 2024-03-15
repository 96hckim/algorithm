package basic_part_1.math_303;

import java.io.*;
import java.util.StringTokenizer;

public class BaseConversion_11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder result = new StringBuilder();
        while (N > 0) {
            int remainder = N % B;
            char digit;
            if (remainder < 10) {
                digit = (char) (remainder + '0');
            } else {
                digit = (char) (remainder - 10 + 'A');
            }
            result.append(digit);
            N /= B;
        }

        bw.write(result.reverse().toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
