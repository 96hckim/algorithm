package CompetencyTest;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Download {

    private static class Person {

        int y, x, d;

        public Person(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }

        void move(int dir) {
            this.y += dy[dir];
            this.x += dx[dir];
        }

        void download(int speed) {
            if (this.d - speed > 0) this.d -= speed;
            else this.d = 0;
        }

    }

    private static class AP {

        int y, x, r, d;

        public AP(int y, int x, int r, int d) {
            this.y = y;
            this.x = x;
            this.r = r;
            this.d = d;
        }

    }

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N; // 지도의 세로 크기
    private static int M; // 지도의 가로 크기
    private static int K; // 공유기의 개수
    private static AP[][][] map; // 지도
    private static int[][] size; // 좌표의 AP 갯수
    private static int S; // A와 B의 이동 길이
    private static int[] moveA; // A의 이동 경로
    private static int[] moveB; // B의 이동 경로
    private static final int[] dy = {0, -1, 0, 1, 0}; // y축 이동
    private static final int[] dx = {0, 0, 1, 0, -1}; // x축 이동
    private static Person A; // A
    private static Person B; // B

    // 입력
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new AP[N + 1][M + 1][K];
        size = new int[N + 1][M + 1];

        // 지도 초기화
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            setSpeed(new AP(y, x, r, d));
        }

        // A, B 이동 거리 초기화
        S = Integer.parseInt(br.readLine());

        moveA = new int[S + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= S; i++) moveA[i] = Integer.parseInt(st.nextToken());

        moveB = new int[S + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= S; i++) moveB[i] = Integer.parseInt(st.nextToken());

        // A, B 초기화
        st = new StringTokenizer(br.readLine());
        int ay = Integer.parseInt(st.nextToken());
        int ax = Integer.parseInt(st.nextToken());
        int ad = Integer.parseInt(st.nextToken());
        A = new Person(ay, ax, ad);

        st = new StringTokenizer(br.readLine());
        int by = Integer.parseInt(st.nextToken());
        int bx = Integer.parseInt(st.nextToken());
        int bd = Integer.parseInt(st.nextToken());
        B = new Person(by, bx, bd);
    }

    // 지도의 공유기 주변에 다운로드 속도 지정
    private static void setSpeed(AP ap) {
        for (int i = ap.y - ap.r; i <= ap.y + ap.r; i++) {
            if (i < 1) continue;
            else if (i > N) break;

            for (int j = ap.x - ap.r; j <= ap.x + ap.r; j++) {
                if (j < 1) continue;
                else if (j > M) break;

                if (Math.abs(ap.y - i) + Math.abs(ap.x - j) <= ap.r) map[i][j][size[i][j]++] = ap;
            }
        }

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
            moving();
            bw.write("#" + t + " " + A.d + " " + B.d + "\n"); // 가장 많이 꺾은 수 출력
        }

        output();

    }

    // A, B 이동
    private static void moving() {
        for (int s = 0; s <= S; s++) {
            A.move(moveA[s]);
            B.move(moveB[s]);
            selectAP();
        }
    }

    // 공유기 선택
    private static void selectAP() {
        ArrayList<AP> apA = new ArrayList<>(size[A.y][A.x]); // A 좌표 공유기 리스트
        ArrayList<AP> apB = new ArrayList<>(size[B.y][B.x]); // B 좌표 공유기 리스트

        apA.addAll(Arrays.asList(map[A.y][A.x]).subList(0, size[A.y][A.x]));
        apB.addAll(Arrays.asList(map[B.y][B.x]).subList(0, size[B.y][B.x]));

        int max = Integer.MIN_VALUE;
        int downloadA = 0; // A 가 다운로드 받을 용량
        int downloadB = 0; // B 가 다운로드 받을 용량

        if (apA.size() > 0 && apB.size() > 0) { // A 좌표와 B 좌표 둘다 공유기가 1개 이상 있을때
            for (AP a : apA) {
                for (AP b : apB) {
                    int ad = a.d;
                    int bd = b.d;
                    int sum = ad + bd;

                    if (a.equals(b)) { // 같은 공유기라면 속도 절반
                        ad /= 2;
                        bd /= 2;
                        sum /= 2;
                    }

                    if (max < sum) { // 가장 많은 용량 다운로드
                        max = sum;
                        downloadA = ad;
                        downloadB = bd;
                    } else if (max == sum) { // 용량이 같다면 다운로드 받을 용량 많이 남은 쪽이 큰 경우
                        if (A.d >= B.d) { // A 의 다운로드 받을 용량이 크거나 같으면 A 가 큰 용량 선택
                            if (ad > downloadA) {
                                downloadA = ad;
                                downloadB = bd;
                            }
                        } else {
                            if (bd > downloadB) {
                                downloadA = ad;
                                downloadB = bd;
                            }
                        }
                    }
                }
            }
        } else { // 둘다 좌표에 공유기가 없거나 한 쪽이 없는 경우
            for (AP a : apA) if (downloadA < a.d) downloadA = a.d;
            for (AP b : apB) if (downloadB < b.d) downloadB = b.d;
        }

        downloading(downloadA, downloadB);
    }

    // 지정된 용량 다운로드
    private static void downloading(int downloadA, int downloadB) {
        A.download(downloadA);
        B.download(downloadB);
    }

}
