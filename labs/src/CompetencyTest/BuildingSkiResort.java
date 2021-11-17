package CompetencyTest;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Build {

    int y, x, d, bend;
    boolean cut;

    public Build(int y, int x, int d, int bend, boolean cut) {
        this.y = y;
        this.x = x;
        this.d = d;
        this.bend = bend;
        this.cut = cut;
    }

}

public class BuildingSkiResort {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N; // 산의 크기
    private static int K; // 최대로 깎을 수 있는 높이
    private static int[][] mountain; // 산 정보가 담긴 배열
    private static ArrayList<Build> top; // 산꼭대기
    private static int HEIGHT; // 가장 큰 높이
    private static boolean[][] built; // 건설한 곳인지
    private static int MAX_BEND; // 가장 많이 꺾인 수

    private static final int[] dy = {-1, 1, 0, 0}; // 상하
    private static final int[] dx = {0, 0, -1, 1}; // 좌우
    private static final int[][] bendCheck = new int[5][5]; // 꺾어야 하는지 체크

    // 입력
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        mountain = new int[N][N];
        built = new boolean[N][N];
        HEIGHT = Integer.MIN_VALUE;
        MAX_BEND = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                mountain[i][j] = Integer.parseInt(st.nextToken());

                if (HEIGHT < mountain[i][j]) {
                    top = new ArrayList<>();
                    HEIGHT = mountain[i][j];
                    top.add(new Build(i, j, 4, 0, false));
                } else if (HEIGHT == mountain[i][j]) {
                    top.add(new Build(i, j, 4, 0, false));
                }
            }
        }
    }

    // 출력
    private static void output() throws IOException {
        br.close();
        bw.flush();
        bw.close();
    }

    // 꺾어야 한다면 +1
    private static void init() {
        bendCheck[0][2] = 1;
        bendCheck[0][3] = 1;
        bendCheck[1][2] = 1;
        bendCheck[1][3] = 1;
        bendCheck[2][0] = 1;
        bendCheck[2][1] = 1;
        bendCheck[3][0] = 1;
        bendCheck[3][1] = 1;
    }

    // 메인
    public static void main(String[] args) throws IOException {
        init();

        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            input();
            search();
            bw.write("#" + t + " " + MAX_BEND + "\n"); // 가장 많이 꺾은 수 출력
        }

        output();

    }

    // 건설해야할 장소 찾기
    private static void search() {
        for (Build b : top) dfs(b);
    }

    // 정상에서 가장 많이 꺾을 수 있는 건설 장소 탐색
    private static void dfs(Build b) {
        built[b.y][b.x] = true;

        for (int i = 0; i < 4; i++) { // 상하좌우 탐색
            int ny = b.y + dy[i];
            int nx = b.x + dx[i];
            int bend = b.bend + bendCheck[b.d][i];

            if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                if (!built[ny][nx]) { // 건설하지 않은 곳
                    if (mountain[b.y][b.x] > mountain[ny][nx]) { // 현재 지역보다 낮은 곳
                        dfs(new Build(ny, nx, i, bend, b.cut));
                    } else {
                        if (!b.cut && mountain[b.y][b.x] - 1 >= 0 && mountain[ny][nx] < HEIGHT) {
                            if (mountain[ny][nx] - (mountain[b.y][b.x] - 1) <= K) { // 지형 깎을 수 있는 수치 이내
                                int temp = mountain[ny][nx];
                                mountain[ny][nx] = mountain[b.y][b.x] - 1;
                                dfs(new Build(ny, nx, i, bend, true));
                                mountain[ny][nx] = temp;
                            }
                        }
                    }
                }
            }
        }

        if (MAX_BEND < b.bend) MAX_BEND = b.bend;
        built[b.y][b.x] = false;
    }

}
