package Level5;

import java.io.*;
import java.util.StringTokenizer;

public class FractionSum {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        st = new StringTokenizer(br.readLine());
        int[] b = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        int child = a[0] * b[1] + b[0] * a[1];
        int parent = a[1] * b[1];
        int gcd = gcd(parent, child);

        int[] result = {child / gcd, parent / gcd};

        bw.write(result[0] + " " + result[1]);

        br.close();
        bw.flush();
        bw.close();

    }

    static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return gcd(b, a % b);
    }

}
