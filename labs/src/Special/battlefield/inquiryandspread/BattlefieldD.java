package Special.battlefield.inquiryandspread;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BattlefieldD {

    private static int N;
    private static int K;
    private static int[][] map;
    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};
    private static int minY;
    private static int minX;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        int y = -1;
        int x = -1;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findMe:
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 9) {
                    y = i;
                    x = j;
                    break findMe;
                }
            }
        }

        String[][] result = bfs(y, x);

        bw.write(minY + " " + minX);

        br.close();
        bw.flush();
        bw.close();

    }

    private static String[][] bfs(int i, int j) {

        String[][] result = new String[N + 1][N + 1];
        result[i][j] = "*";

        int[][] distance = new int[N + 1][N + 1];
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

                        if (map[y][x] <= K) {
                            distance[y][x] = distance[points[0]][points[1]] + 1;
                            needVisit.add(new int[]{y, x});

                            if (map[y][x] > 0) {
                                if (map[y][x] != K) result[y][x] = String.valueOf(distance[y][x]);
                                else result[y][x] = ".";
                            } else {
                                result[y][x] = "0";
                            }
                        } else {
                            result[y][x] = "X";
                        }
                    }
                }

            }

        }

        inquiry(distance);

        return result;

    }

    private static void inquiry(int[][] distance) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] > 0 && map[i][j] < K) {
                    int value = distance[i][j];
                    if (value > 0) {
                        if (min > value) {
                            min = value;
                            minY = i;
                            minX = j;
                        }
                    }
                }
            }
        }
    }

}