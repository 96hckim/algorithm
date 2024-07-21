package CompetencyTest.practice;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ICEBERG {

    private static int N; // 행의 개수
    private static int M; // 열의 개수
    private static int[][] map; // 빙산 배열

    private static boolean[][] visited; // 방문했는지 체크

    private static final int[] dy = {-1, 1, 0, 0}; // 상하
    private static final int[] dx = {0, 0, -1, 1}; // 좌우

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int yearCount = -1; // 두 덩어리로 분리되는 시간
        while (true) { // 1년 단위로 빙산을 녹인다
            yearCount++;

            visited = new boolean[N][M];
            int icebergCount = 0; // 빙산 덩어리 수
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if (map[i][j] > 0 && !visited[i][j]) {
                        icebergCount++;
                        meltingIceberg(i, j);
                    }
                }
            }

            if (icebergCount >= 2) { // 두 덩어리 이상이면 걸린 년수 출력
                bw.write(yearCount + "");
                break;
            } else if (icebergCount == 0) { // 다 녹을 동안 두 덩어리로 분리된적 없다면 0 출력
                bw.write(0 + "");
                break;
            }
        }

        br.close();
        bw.flush();
        bw.close();

    }

    // 빙산 녹이는 함수
    private static void meltingIceberg(int i, int j) {

        Queue<int[]> needVisit = new LinkedList<>();
        needVisit.add(new int[]{i, j});
        visited[i][j] = true;

        while (!needVisit.isEmpty()) {

            int[] pos = needVisit.poll();
            int y = pos[0];
            int x = pos[1];

            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];

                if (!visited[ny][nx]) {
                    if (map[ny][nx] > 0) {
                        visited[ny][nx] = true;
                        needVisit.add(new int[]{ny, nx});
                    } else {
                        if (map[y][x] > 0) map[y][x]--;
                    }
                }
            }

        }

    }

}
