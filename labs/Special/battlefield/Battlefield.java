package Special.battlefield;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Battlefield {

    private static int N;          // 전쟁터 크기
    private static int[][] map;    // 전쟁터 배열

    private static final int[] dy = {-1, 1, 0, 0}; // y 방향
    private static final int[] dx = {0, 0, -1, 1}; // x 방향

    private static int LEVEL;       // 레벨
    private static int LEVEL_COUNT; // 경험치

    private static int TIME;        // 최단 거리 적 사살 시간
    private static int KILLED_Y;    // 사살한 위치 y 좌표
    private static int KILLED_X;    // 사살한 위치 x 좌표

    private static int RESULT;      // 모든 적 섬멸 소요 시간

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 테스트 케이스
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {

            // 초기화
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            RESULT = 0;
            LEVEL = 2; // 초기 레벨 2 부터 시작
            LEVEL_COUNT = 0;

            int y = -1; // 낙하 지점 y 좌표
            int x = -1; // 낙하 지점 x 좌표

            // 맵 셋팅 및 낙하 지점 가져오기
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    map[i][j] = value;
                    if (value == 9) {
                        map[i][j] = 0;
                        y = i;
                        x = j;
                    }
                }
            }

            // 모든 적 섬멸
            destroyTheEnemy(y, x);

            // 소요 시간 출력
            bw.write("#" + t + " " + RESULT + "\n");

        }

        br.close();
        bw.flush();
        bw.close();

    }

    // 사살 가능한 적과의 거리 계산 후 가장 가까운 적 사살
    private static void destroyTheEnemy(int i, int j) {

        int[][] distances = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        ArrayList<int[]> needVisit = new ArrayList<>();
        needVisit.add(new int[]{i, j});
        visited[i][j] = true;

        while (!needVisit.isEmpty()) {

            int[] points = needVisit.remove(0);

            for (int k = 0; k < 4; k++) {
                int y = points[0] + dy[k];
                int x = points[1] + dx[k];

                if (y >= 0 && y < N && x >= 0 && x < N) {
                    if (!visited[y][x]) {
                        visited[y][x] = true;

                        if (map[y][x] <= LEVEL) {
                            distances[y][x] = distances[points[0]][points[1]] + 1;
                            needVisit.add(new int[]{y, x});
                        }
                    }
                }
            }

        }

        // 모든 적을 섬멸하였는가
        if (!kill(distances)) {
            if (++LEVEL_COUNT == LEVEL) { // 경험치가 레벨과 같아지면 레벨업
                LEVEL++;
                LEVEL_COUNT = 0;
            }
            RESULT += TIME;
            map[i][j] = 0;
            map[KILLED_Y][KILLED_X] = 0;
            destroyTheEnemy(KILLED_Y, KILLED_X);
        }

    }

    // 적 사살
    private static boolean kill(int[][] distances) {
        boolean isClear = true;
        TIME = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 0 && map[i][j] < LEVEL) { // 레벨보다 낮은 적
                    int distance = distances[i][j];
                    if (distance > 0) {
                        if (TIME > distance) { // 사살한 적 좌표로 이동
                            TIME = distance;
                            KILLED_Y = i;
                            KILLED_X = j;
                            isClear = false;
                        }
                    }
                }
            }
        }

        return isClear;
    }

}
