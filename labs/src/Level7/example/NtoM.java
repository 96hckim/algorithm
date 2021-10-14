package Level7.example;

import java.io.*;
import java.util.StringTokenizer;

/**
 * n 부터 m 까지의 합
 */
public class NtoM {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        bw.write(getNtoM(n, m) + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static int getNtoM(int n, int m) {
        if (n == m) {
            return m;
        }

        return n + getNtoM(n + 1, m);
    }

}
