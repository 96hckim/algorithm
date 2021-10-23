package Special.spindleandrobot.move;

import java.io.*;
import java.util.StringTokenizer;

public class BoundaryHandling {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[][] arr = new String[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = st.nextToken();
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = arr[i][arr[0].length - 1] = "-1";
        }

        for (int i = 0; i < arr[0].length; i++) {
            arr[0][i] = arr[arr.length - 1][i] = "-1";
        }

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken()) + 1;
        int x = Integer.parseInt(st.nextToken()) + 1;
        int d = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < r; i++) {

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (arr[ny][nx].equals("-1")) {
                break;
            }

            x += dx[d];
            y += dy[d];

        }

        bw.write(arr[y][x]);

        br.close();
        bw.flush();
        bw.close();

    }

}
