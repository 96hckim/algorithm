package Special.battlefield.inquiryandspread;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BattlefieldD {

    private static int N;
    private static int K;
    private static int[][] map;

    private static int Y;
    private static int X;

    private static int MIN;
    private static int minY;
    private static int minX;

    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        MIN = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    Y = i;
                    X = j;
                }
            }
        }

        getMinPos(bfs());

        bw.write(minY + " " + minX);

        br.close();
        bw.flush();
        bw.close();

    }

    private static int[][] bfs() {

        int[][] distances = new int[N + 1][N + 1];
        boolean[][] visited = new boolean[N + 1][N + 1];
        Queue<int[]> needVisit = new LinkedList<>();
        needVisit.add(new int[]{Y, X});
        visited[Y][X] = true;

        while (!needVisit.isEmpty()) {

            int[] pos = needVisit.poll();
            int y = pos[0];
            int x = pos[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny > 0 && ny <= N && nx > 0 && nx <= N) {
                    if (!visited[ny][nx]) {
                        visited[ny][nx] = true;

                        if (map[ny][nx] <= K) {
                            distances[ny][nx] = distances[y][x] + 1;
                            needVisit.add(new int[]{ny, nx});
                        }
                    }
                }
            }

        }

        return distances;

    }

    private static void getMinPos(int[][] distances) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] > 0 && map[i][j] < K) {
                    if (distances[i][j] > 0 && MIN > distances[i][j]) {
                        MIN = distances[i][j];
                        minY = i;
                        minX = j;
                    }
                }
            }
        }
    }

}
