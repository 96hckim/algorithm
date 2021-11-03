package Level19;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Maze {

    private static int[][] map;
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n + 2][m + 2];
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(map[i], -1);
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                int canMove = Integer.parseInt(st.nextToken());
                if (canMove == 0) map[i][j] = canMove;
            }
        }

        bfs(n, 1);

        bw.write(map[1][m] + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static void bfs(int i, int j) {

        ArrayList<int[]> needVisit = new ArrayList<>();
        needVisit.add(new int[]{i, j});

        while (!needVisit.isEmpty()) {

            int[] coordinate = needVisit.remove(0);

            for (int k = 0; k < 4; k++) {
                int y = coordinate[0] + dy[k];
                int x = coordinate[1] + dx[k];

                if (map[y][x] == 0) {
                    map[y][x] = map[coordinate[0]][coordinate[1]] + 1;
                    needVisit.add(new int[]{y, x});
                }
            }

        }

    }

}
