package CompetencyTest;

import java.io.*;
import java.util.StringTokenizer;

public class Download {

    private static class Person {

        int y, x, d;
        AP used = new AP();

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

        int y, x, r, d = 0;

        public AP() {
        }

        public AP(int y, int x, int r, int d) {
            this.y = y;
            this.x = x;
            this.r = r;
            this.d = d;
        }

        @Override
        public boolean equals(Object obj) {
            AP ap = (AP) obj;
            return this.y == ap.y && this.x == ap.x && this.r == ap.r;
        }

        @Override
        public String toString() {
            return "{" + y +
                    ", " + x +
                    ", " + r +
                    ", " + d +
                    '}';
        }
    }

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N; // 지도의 세로 크기
    private static int M; // 지도의 가로 크기
    private static int K; // 공유기의 개수
    private static AP[][][] map; // 지도
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
        map = new AP[N + 1][M + 1][5];

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
        for (int i = 1; i <= S; i++) {
            moveA[i] = Integer.parseInt(st.nextToken());
        }

        moveB = new int[S + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= S; i++) {
            moveB[i] = Integer.parseInt(st.nextToken());
        }

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

                if (Math.abs(ap.y - i) + Math.abs(ap.x - j) <= ap.r) {
                    for (int k = 0; k < 5; k++) {
                        if (map[i][j][k] == null) {
                            map[i][j][k] = ap;
                            break;
                        }
                    }
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

    private static void moving() {
        for (int s = 0; s <= S; s++) {
            A.move(moveA[s]);
            B.move(moveB[s]);

            AP max = new AP();

            for (AP ap : map[A.y][A.x]) {
                if (ap == null) break;
                if (B.used.equals(ap)) {
                    if (max.d < (ap.d / 2)) {
                        max = new AP(ap.y, ap.x, ap.r, ap.d);
                    }
                } else {
                    if (max.d < ap.d) {
                        max = new AP(ap.y, ap.x, ap.r, ap.d);
                    }
                }
            }

            A.used = max;

            max = new AP();
            for (AP ap : map[B.y][B.x]) {
                if (ap == null) break;
                if (A.used.equals(ap)) {
                    if (max.d < (ap.d / 2)) {
                        max = new AP(ap.y, ap.x, ap.r, ap.d);
                    }
                } else {
                    if (max.d < ap.d) {
                        max = new AP(ap.y, ap.x, ap.r, ap.d);
                    }
                }
            }

            B.used = max;

            downloading(A, B);
            downloading(B, A);
        }
    }

    private static void downloading(Person person, Person other) {
        if (person.used.equals(other.used)) person.download(person.used.d / 2);
        else person.download(person.used.d);
    }

}
