package Special.battlefield.inquiry;

import java.io.*;
import java.util.StringTokenizer;

public class BattlefieldA {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int value = Integer.parseInt(st.nextToken());
                arr[i][j] = value;
                if (value != 0 && min > value) min = value;
            }
        }

        inquiry:
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == min) {
                    bw.write(i + " " + j);
                    break inquiry;
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
