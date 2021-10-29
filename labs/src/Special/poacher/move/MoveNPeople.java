package Special.poacher.move;

import java.io.*;
import java.util.StringTokenizer;

public class MoveNPeople {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 2][m + 2];
        insertBoundary(arr);

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());

            for (int j = 0; j < t * f; j++) {

                int ny = y + dy[d];
                int nx = x + dx[d];

                if (arr[ny][nx] == -1) break;

                y = ny;
                x = nx;

            }

            bw.write(y + " " + x + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static void insertBoundary(int[][] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            arr[i][0] = arr[i][arr[0].length - 1] = -1;
        }

        for (int i = 0; i < arr[0].length - 1; i++) {
            arr[0][i] = arr[arr.length - 1][i] = -1;
        }

    }

}
