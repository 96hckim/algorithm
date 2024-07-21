package Level19;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Maze {

    private static int n;
    private static int m;
    private static int[][] map;
    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(n - 1, 0);

        bw.write(map[0][m - 1] + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static void bfs(int i, int j) {

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {

            int[] pos = queue.poll();
            visited[pos[0]][pos[1]] = true;

            for (int k = 0; k < 4; k++) {

                int y = pos[0] + dy[k];
                int x = pos[1] + dx[k];

                if (y >= 0 && y < n && x >= 0 && x < m) {
                    if (map[y][x] == 0 && !visited[y][x]) {
                        map[y][x] = map[pos[0]][pos[1]] + 1;
                        queue.add(new int[]{y, x});
                    }
                }

            }

        }

    }

}
