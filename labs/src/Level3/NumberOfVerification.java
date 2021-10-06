package Level3;

import java.io.*;
import java.util.StringTokenizer;

public class NumberOfVerification {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        double powSum = 0;
        while (st.hasMoreTokens()) {
            powSum += Math.pow(Integer.parseInt(st.nextToken()), 2);
        }

        bw.write(String.valueOf((int) (powSum % 10)));

        br.close();
        bw.flush();
        bw.close();

    }

}