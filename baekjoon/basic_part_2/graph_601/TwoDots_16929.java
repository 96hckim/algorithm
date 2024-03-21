package basic_part_2.graph_601;

import java.io.*;
import java.util.StringTokenizer;

public class TwoDots_16929 {
    static int N, M;
    static char[][] board;
    static boolean[][] visited;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        boolean result = false;

        // 모든 칸에서 DFS 수행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    if (dfs(i, j, -1, -1, board[i][j])) {
                        result = true;
                        break;
                    }
                }
            }
        }

        if (result)
            bw.write("Yes");
        else
            bw.write("No");

        br.close();
        bw.flush();
        bw.close();
    }

    // DFS 로 사이클 확인
    static boolean dfs(int x, int y, int prevX, int prevY, char color) {
        visited[x][y] = true;

        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            // 다음 칸이 이전에 방문한 정점이 아니거나, 이전에 방문한 칸과 연결된 경우에만 탐색
            if (isValid(nextX, nextY) && !(nextX == prevX && nextY == prevY) && board[nextX][nextY] == color) {
                if (visited[nextX][nextY] || dfs(nextX, nextY, x, y, color))
                    return true;
            }
        }

        return false;
    }

    // 인덱스가 유효한지 확인
    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
