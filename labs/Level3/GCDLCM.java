package Level3;

import java.io.*;
import java.util.StringTokenizer;

public class GCDLCM {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        bw.write(getGcd(a, b) + "\n");
        bw.write(getLcm(a, b) + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static int getGcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return getGcd(b, a % b);
    }

    private static int getLcm(int a, int b) {
        return a * b / getGcd(a, b);
    }

}
