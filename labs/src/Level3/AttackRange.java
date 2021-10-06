package Level3;

import java.io.*;
import java.util.StringTokenizer;

public class AttackRange {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 2 * r][n + 2 * r];

        int realX = x + r - 1;
        int realY = y + r - 1;

        for (int i = -r; i <= r; i++) {
            for (int j = -r; j <= r; j++) {
                int distance = Math.abs(i) + Math.abs(j);

                if (distance <= r) {
                    arr[realX + i][realY + j] = distance;
                }
            }
        }

        for (int i = r; i <= r + n - 1; i++) {
            for (int j = r; j <= r + n - 1; j++) {
                if (realX == i && realY == j) {
                    bw.write("x ");
                } else {
                    bw.write(arr[i][j] + " ");
                }
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
