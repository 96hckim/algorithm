package Special.battlefield.spread;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BattlefieldC {

    private static int N;
    private static int K;
    private static int[][] map;

    private static int Y;
    private static int X;

    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    Y = i;
                    X = j;
                }
            }
        }

        String[][] result = getResult(getDistances());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(result[i][j] + " ");
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static int[][] getDistances() {

        int[][] distances = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> needVisit = new LinkedList<>();
        needVisit.add(new int[]{Y, X});
        visited[Y][X] = true;

        while (!needVisit.isEmpty()) {

            int[] pos = needVisit.poll();

            for (int i = 0; i < 4; i++) {
                int ny = pos[0] + dy[i];
                int nx = pos[1] + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                    if (!visited[ny][nx]) {
                        visited[ny][nx] = true;

                        if (map[ny][nx] <= K) {
                            distances[ny][nx] = distances[pos[0]][pos[1]] + 1;
                            needVisit.add(new int[]{ny, nx});
                        }
                    }
                }
            }

        }

        return distances;

    }

    private static String[][] getResult(int[][] distances) {
        String[][] result = new String[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) result[i][j] = "0";
                else if (map[i][j] == K) result[i][j] = ".";
                else if (map[i][j] > K) result[i][j] = "X";
                else result[i][j] = String.valueOf(distances[i][j] == 0 ? -1 : distances[i][j]);
            }
        }

        result[Y][X] = "*";

        return result;
    }

}
