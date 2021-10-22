package Special.aircleaner.spread;

import java.io.*;
import java.util.StringTokenizer;

public class TwoDSpread {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t;
        int[][] arr = new int[n + 2][m + 2];
        int[][] spreadArray;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = arr[i][arr[0].length - 1] = -1;
        }

        for (int i = 0; i < arr[0].length; i++) {
            arr[0][i] = arr[arr.length - 1][i] = -1;
        }

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            spreadArray = new int[n + 2][m + 2];

            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= m; k++) {
                    for (int l = 0; l < 4; l++) {
                        int nx = j + dx[l];
                        int ny = k + dy[l];

                        if (arr[nx][ny] != -1) spreadArray[nx][ny] += arr[j][k];
                    }
                }
            }

            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= m; k++) {
                    arr[j][k] += spreadArray[j][k];
                }
            }

        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
