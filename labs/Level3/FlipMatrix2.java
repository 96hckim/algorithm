package Level3;

import java.io.*;
import java.util.StringTokenizer;

public class FlipMatrix2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[10][10];

        StringTokenizer st;
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == j) {
                    arr[i][j] = arr[i][j] == 0 ? 1 : 0;
                    continue;
                }

                arr[i][j] = arr[i][j] == 0 ? 1 : 0;
                arr[j][i] = arr[j][i] == 0 ? 1 : 0;
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
