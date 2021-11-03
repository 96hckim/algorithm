package Level19;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CarpentersMazeEscape {

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
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], -1);
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                int canMove = Integer.parseInt(st.nextToken());
                map[i][j] = canMove;
            }
        }

        int[][] start = bfs(n, 1);
        int[][] end = bfs(1, m);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 1) {
                    if (start[i][j] != 0 && end[i][j] != 0) {
                        int distance = start[i][j] + end[i][j];
                        if (min > distance) min = distance;
                    }
                }
            }
        }

        bw.write(min + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static int[][] bfs(int i, int j) {

        int[][] result = new int[map.length][map[0].length];
        boolean[][] visited = new boolean[map.length][map[0].length];

        ArrayList<int[]> needVisit = new ArrayList<>();
        needVisit.add(new int[]{i, j});

        while (!needVisit.isEmpty()) {

            int[] currentPosition = needVisit.remove(0);
            visited[currentPosition[0]][currentPosition[1]] = true;

            for (int k = 0; k < 4; k++) {
                int y = currentPosition[0] + dy[k];
                int x = currentPosition[1] + dx[k];

                if (!visited[y][x]) {
                    visited[y][x] = true;

                    if (map[y][x] == 0) {
                        result[y][x] = result[currentPosition[0]][currentPosition[1]] + 1;
                        needVisit.add(new int[]{y, x});
                    } else if (map[y][x] == 1) {
                        result[y][x] = result[currentPosition[0]][currentPosition[1]] + 1;
                    }
                }
            }

        }

        return result;

    }

}
