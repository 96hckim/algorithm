package Level5.example;

import java.io.*;

/**
 * 파스칼 삼각형 (조합)
 */
public class Pascal {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == i || j == 1) arr[i][j] = 1;
                else arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                bw.write(arr[i][j] + " ");
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
