package Level7.example;

import java.io.*;
import java.util.StringTokenizer;

/**
 * n 의 m 승 구하기
 */
public class GetPower {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        bw.write(getPower(n, m) + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static int getPower(int n, int m) {
        if (m == 0) {
            return 1;
        }
        return n * getPower(n, m - 1);
    }

}
