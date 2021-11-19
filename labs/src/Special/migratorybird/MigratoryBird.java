package Special.migratorybird;

import java.io.*;
import java.util.StringTokenizer;

class Bird {

    int n, y, x, d, i;

    public Bird(int n, int y, int x, int d, int i) {
        this.n = n;
        this.y = y;
        this.x = x;
        this.d = d;
        this.i = i;
    }

    @Override
    public String toString() {
        return "{" +
                "n=" + n +
                ", y=" + y +
                ", x=" + x +
                ", d=" + d +
                ", i=" + i +
                '}';
    }

}

public class MigratoryBird {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N; // 비행 영역의 크기
    private static int K; // 철새의 수

    private static int[][] area; // 비행 영역
    private static Bird[][][] map; // 비행 영역의 철새 위치
    private static int[][] size; // 영역별 철새 수
    private static Bird[] birds; // 영역 내 철새들

    private static int TIME_LIMIT; // 시간 제한
    private static boolean IS_CLEAR; // 최소 4마리 철새가 겹쳤는지
    private static int result; // 결과(최소 4마리의 철새가 겹치는 시간)

    private static final int[] dy = {-1, 1, 0, 0}; // 상하
    private static final int[] dx = {0, 0, -1, 1}; // 좌우
    private static final int[] rd = {1, 0, 3, 2}; // 좌우

    // 입력
    private static void input() throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        area = new int[N + 2][N + 2];
        map = new Bird[N + 1][N + 1][K];
        size = new int[N + 1][N + 1];
        birds = new Bird[K];

        TIME_LIMIT = 1000;
        IS_CLEAR = false;
        result = -1;

        // 비행 영역 초기화(0:어둠, 1:빛, 2:나무)
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 경계선 처리
        boundary();

        // 철새 초기화
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) + 1;
            int x = Integer.parseInt(st.nextToken()) + 1;
            int d = Integer.parseInt(st.nextToken());
            birds[i] = new Bird(i + 1, y, x, d, size[y][x]);
            map[y][x][size[y][x]++] = birds[i];
        }

    }

    // 영역 외 나무로 채운다
    private static void boundary() {
        for (int i = 0; i < area.length; i++) area[i][0] = area[i][area.length - 1] = 2;
        for (int i = 0; i < area.length; i++) area[0][i] = area[area.length - 1][i] = 2;
    }

    // 출력
    private static void output() throws IOException {
        br.close();
        bw.flush();
        bw.close();
    }

    // 메인
    public static void main(String[] args) throws IOException {

        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            input();

            while (!IS_CLEAR && TIME_LIMIT > 0) { // 철새 4마리 이상 모이거나 1000초 지났으면 나온다
                TIME_LIMIT--;
                move();
            }

            if (TIME_LIMIT > 0) result = 1000 - TIME_LIMIT;
            System.out.print("#" + t + " " + result + "\n"); // 결과 출력
        }

        output();

    }

    private static void move() {

        for (Bird bird : birds) {

            int y = bird.y;
            int x = bird.x;
            int d = bird.d;
            int index = bird.i;

            int ny = y + dy[d];
            int nx = x + dx[d];

            if (area[ny][nx] == 2) {
                bird.d = rd[d];
                ny = y + dy[bird.d];
                nx = x + dx[bird.d];
                if (area[ny][nx] == 2) continue;
            }

            if (area[ny][nx] == 0) {
                int cur = size[ny][nx];
                int c = size[y][x] - index;
                size[ny][nx] += c;
                for (int i = size[ny][nx] - 1; i >= size[ny][nx] - cur; i--) {
                    if (i - c >= 0) {
                        map[ny][nx][i] = map[ny][nx][i - c];
                        map[ny][nx][i].i = i;
                    }
                }
            }

            for (int i = index; i < size[y][x]; i++) {

                map[y][x][i].y = ny;
                map[y][x][i].x = nx;

                if (area[ny][nx] == 0) {
                    map[y][x][i].i = i - index;
                    map[ny][nx][map[y][x][i].i] = map[y][x][i];
                } else if (area[ny][nx] == 1) {
                    map[y][x][i].i = size[ny][nx];
                    map[ny][nx][size[ny][nx]++] = map[y][x][i];
                }

                map[y][x][i] = null;

            }

            size[y][x] = index;

            if (size[ny][nx] >= 4) {
                IS_CLEAR = true;
                return;
            }

        }

    }

}
