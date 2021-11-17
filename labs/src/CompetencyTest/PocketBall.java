package CompetencyTest;

import java.io.*;
import java.util.*;

class Ball implements Comparable<Ball> {

    int n, y, x, f, d;

    public Ball(int n, int y, int x, int f, int d) {
        this.n = n;
        this.y = y;
        this.x = x;
        this.f = f;
        this.d = d;
    }

    @Override
    public boolean equals(Object obj) {
        Ball ball = (Ball) obj;
        return this.n == ball.n;
    }

    @Override
    public int compareTo(Ball ball) {
        return this.n - ball.n;
    }

    @Override
    public String toString() {
        return "{" +
                "n=" + n +
                ", y=" + y +
                ", x=" + x +
                ", f=" + f +
                ", d=" + d +
                '}';
    }

}

public class PocketBall {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N; // 당구장 세로 크기
    private static int M; // 당구장 가로 크기
    private static int S; // 시간
    private static int K; // 당구공 개수

    private static Ball[][] table; // 당구대
    private static ArrayList<Ball> removeList; // 사라진 당구공
    private static Queue<Ball> balls; // 남아있는 당구공
    private static StringBuilder result; // 사라진 당구공 오름차순으로 정렬한 결과

    private static final int[] dy = {0, -1, 1, 0, 0}; // y축 이동
    private static final int[] dx = {0, 0, 0, -1, 1}; // x축 이동
    private static final int[] rd = {0, 2, 1, 4, 3}; // 방향 반전

    // 입력
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        table = new Ball[N][M];
        removeList = new ArrayList<>(K);
        balls = new LinkedList<>();
        result = new StringBuilder();

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            table[y][x] = new Ball(i, y, x, f, d);
            balls.add(table[y][x]);
            removeList.add(table[y][x]);
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
            for (int i = 0; i < S; i++) move();
            getResult();
            bw.write("#" + t + " " + result + "\n");
        }

        output();

    }

    // 당구공 이동
    private static void move() {

        Ball[][] temp = new Ball[N][M]; // 이동 임시 당구대
        boolean[][] removed = new boolean[N][M]; // 현재 좌표 충돌이 있었는지
        ArrayList<int[]> positions = new ArrayList<>(); // 이동한 좌표들

        while (!balls.isEmpty()) {

            Ball ball = balls.poll();

            int ny = ball.y + dy[ball.d];
            int nx = ball.x + dx[ball.d];

            if (ny < 1 || ny > N - 2 || nx < 1 || nx > M - 2) { // 벽에 닿으면 방향 역전 후 힘 반감
                ball.d = rd[ball.d];
                ball.f /= 2;
                if (ball.f == 0) continue;
                ny = ball.y;
                nx = ball.x;
            }

            ball.y = ny;
            ball.x = nx;

            if (temp[ny][nx] == null) {
                temp[ny][nx] = ball;
                positions.add(new int[]{ny, nx});
            } else {
                removed[ny][nx] = true;

                if (temp[ny][nx].f < ball.f || (temp[ny][nx].f == ball.f && temp[ny][nx].n > ball.n)) {
                    temp[ny][nx] = ball;
                }
            }

        }

        for (int[] pos : positions) {
            int y = pos[0];
            int x = pos[1];
            if (removed[y][x]) temp[y][x].f /= 2;
            if (temp[y][x].f == 0) temp[y][x] = null;
            else balls.add(temp[y][x]);
        }

        table = temp;

    }

    // 사라진 당구공 오름차순으로 정렬 후 결과 변수에 저장
    private static void getResult() {

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (table[i][j] != null) removeList.remove(table[i][j]);
            }
        }

        if (removeList.isEmpty()) result.append("-1");
        else {
            Collections.sort(removeList);
            for (Ball ball : removeList) result.append(ball.n).append(" ");
        }

    }

}
