package CompetencyTest.practice;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ROBOT {

    private static int M; // 공장 세로 길이
    private static int N; // 공장 가로 길이
    private static int[][] map; // 공장 지도

    private static int destY; // 도착 Y 좌표
    private static int destX; // 도착 X 좌표
    private static int destD; // 도착 후 바라볼 방향

    private static final int[] dy = {0, 0, 0, 1, -1}; // 상화
    private static final int[] dx = {0, 1, -1, 0, 0}; // 좌우

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        int startD = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        destY = Integer.parseInt(st.nextToken());
        destX = Integer.parseInt(st.nextToken());
        destD = Integer.parseInt(st.nextToken());

        bw.write(movingRobot(startY, startX, startD) + "");

        br.close();
        bw.flush();
        bw.close();

    }

    // 로봇 이동
    private static int movingRobot(int i, int j, int d) {

        int result = Integer.MAX_VALUE; // 최소 명령 수
        boolean[][][] visited = new boolean[M + 1][N + 1][5];
        Queue<int[]> needVisit = new LinkedList<>();
        needVisit.add(new int[]{i, j, d, 0});
        visited[i][j][d] = true;

        while (!needVisit.isEmpty()) {

            int[] current = needVisit.poll();
            int y = current[0];
            int x = current[1];
            int dir = current[2];
            int count = current[3];

            // 목표 지점에 도착한 경우 최소 명령 수 계산
            if (y == destY && x == destX && dir == destD) {
                if (result > count) result = count;
                break;
            }

            // 1 ~ 3 칸 이동
            for (int k = 1; k <= 3; k++) {
                int ny = y + dy[dir] * k;
                int nx = x + dx[dir] * k;

                if (!(ny > 0 && ny <= M && nx > 0 && nx <= N)) break;
                if (map[ny][nx] == 1) break;
                if (!visited[ny][nx][dir]) {
                    visited[ny][nx][dir] = true;
                    needVisit.add(new int[]{ny, nx, dir, count + 1});
                }
            }

            // 회전
            for (int k = 1; k <= 4; k++) {
                // 방문한적 없고 반대방향 아닌 경우
                if (!visited[y][x][k] && k != reverseDir(dir)) {
                    visited[y][x][k] = true;
                    needVisit.add(new int[]{y, x, k, count + 1});
                }
            }

        }

        return result;

    }

    // 반대방향 리턴
    private static int reverseDir(int dir) {
        switch (dir) {
            case 1:
                return 2;
            case 2:
                return 1;
            case 3:
                return 4;
            case 4:
                return 3;
        }
        return 0;
    }

}
