package Level17;

import java.io.*;
import java.util.StringTokenizer;

public class CollectingResources {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                int resource = Integer.parseInt(st.nextToken());
                map[i][j] = resource + Math.max(map[i - 1][j], map[i][j - 1]);
            }
        }

        bw.write(map[n][m] + "");

        br.close();
        bw.flush();
        bw.close();

    }

}
