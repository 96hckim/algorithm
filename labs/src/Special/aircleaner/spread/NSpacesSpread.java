package Special.aircleaner.spread;

import java.io.*;
import java.util.StringTokenizer;

public class NSpacesSpread {

    private static int n;
    private static int m;
    private static int k;
    private static int t;
    private static int[][] arr;
    private static int[][] spreadArray;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n + 2][m + 2];

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

        spread();

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

    private static void spread() {
        for (int i = 0; i < t; i++) {

            spreadArray = new int[n + 2][m + 2];

            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= m; k++) {
                    getNumberToSpread(j, k);
                }
            }

            updateArray();

        }
    }

    private static void getNumberToSpread(int x, int y) {
        for (int i = x - k; i <= x + k; i++) {
            if (i < 1 || i > n) continue;

            for (int j = y - k; j <= y + k; j++) {

                if (j < 1 || j > m) continue;
                if (i == x && j == y) continue;

                int distance = Math.abs(x - i) + Math.abs(y - j);

                if (distance <= k) spreadArray[i][j] += arr[x][y];

            }
        }
    }

    private static void updateArray() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] += spreadArray[i][j];
            }
        }
    }

}
