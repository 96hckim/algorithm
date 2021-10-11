package Level3;

import java.io.*;
import java.util.StringTokenizer;

public class Mine {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 2][m + 2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (arr[x][y] == 1) {
            bw.write("game over");
        } else {
            int count = 0;

            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {

                    if (arr[x + i - 1][y + j - 1] == 1) {
                        count++;
                    }

                }
            }

            bw.write(count + "");
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
