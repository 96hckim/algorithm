package src;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MazeShortestPath_2178 {
    private static int N, M;
    private static int[][] maze;
    private static boolean[][] visited;
    private static int[][] dist;
    private static final int[] dx = {-1, 1, 0, 0}; // 상하
    private static final int[] dy = {0, 0, -1, 1}; // 좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visited = new boolean[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        bw.write(String.valueOf(dist[N - 1][M - 1]));

        bw.flush();
        br.close();
        bw.close();
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        dist[x][y] = 1; // 시작 칸 포함

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny] && maze[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        dist[nx][ny] = dist[cx][cy] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
