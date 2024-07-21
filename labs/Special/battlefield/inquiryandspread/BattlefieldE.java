package Special.battlefield.inquiryandspread;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BattlefieldE {

    private static int N;
    private static int[][] map;

    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    private static int minDistance;
    private static int minY;
    private static int minX;

    private static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        int y = -1;
        int x = -1;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                if (value == 9) {
                    y = i;
                    x = j;
                }
            }
        }

        bfs(y, x);

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();

    }

    private static void bfs(int i, int j) {

        int[][] distances = new int[N + 1][N + 1];
        boolean[][] visited = new boolean[N + 1][N + 1];
        ArrayList<int[]> needVisit = new ArrayList<>();
        needVisit.add(new int[]{i, j});
        visited[i][j] = true;

        while (!needVisit.isEmpty()) {

            int[] points = needVisit.remove(0);

            for (int k = 0; k < 4; k++) {
                int y = points[0] + dy[k];
                int x = points[1] + dx[k];

                if (y > 0 && y <= N && x > 0 && x <= N) {
                    if (!visited[y][x]) {
                        visited[y][x] = true;
                        distances[y][x] = distances[points[0]][points[1]] + 1;
                        needVisit.add(new int[]{y, x});
                    }
                }
            }

        }

        if (!inquiry(distances)) {
            result += minDistance;
            map[i][j] = 0;
            map[minY][minX] = 9;
            bfs(minY, minX);
        }

    }

    private static boolean inquiry(int[][] distances) {
        minDistance = Integer.MAX_VALUE;
        boolean isClear = true;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 1) {
                    if (minDistance > distances[i][j]) {
                        minDistance = distances[i][j];
                        minY = i;
                        minX = j;
                        isClear = false;
                    }
                }
            }
        }

        return isClear;
    }

}
