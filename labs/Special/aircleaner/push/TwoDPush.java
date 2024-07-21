package Special.aircleaner.push;

import java.io.*;
import java.util.StringTokenizer;

public class TwoDPush {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 2][m + 2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n + 2; i++) {
            arr[i][0] = arr[i][m + 1] = -1;
        }

        for (int i = 0; i < m + 2; i++) {
            arr[0][i] = arr[n + 1][i] = -1;
        }

        int temp = arr[1][1];
        arr[1][1] = arr[2][1];

        int x = 2;
        int y = 1;
        int[] directX = {1, 0, -1, 0};
        int[] directY = {0, 1, 0, -1};
        int direction = 0;

        while (x != 1 || y != 2) {

            int nextX = x + directX[direction];
            int nextY = y + directY[direction];

            if (arr[nextX][nextY] == -1) {
                direction = (direction + 1) % 4;
            }

            nextX = x + directX[direction];
            nextY = y + directY[direction];

            arr[x][y] = arr[nextX][nextY];

            x = nextX;
            y = nextY;

        }

        arr[x][y] = temp;

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
