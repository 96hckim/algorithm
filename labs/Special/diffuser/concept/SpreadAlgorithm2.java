package Special.diffuser.concept;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SpreadAlgorithm2 {

    private static class Perfume {

        int y, x, d;

        public Perfume(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }

    }

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int N;
    private static int M;

    private static int[][] map;
    private static ArrayList<Perfume> perfumes;
    private static int ZERO;
    private static int MIN_TIME;
    private static int TIME;

    private static final int[] dy = {-1, 1, 0, 0}; // Y축 이동
    private static final int[] dx = {0, 0, -1, 1}; // X축 이동

    // 입력
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        perfumes = new ArrayList<>();
        ZERO = 0;
        MIN_TIME = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) ZERO++;
                else if (map[i][j] == 2) perfumes.add(new Perfume(i, j, 0));
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
        input();
        for (Perfume perfume : perfumes) if (spread(perfume)) if (MIN_TIME > TIME) MIN_TIME = TIME;
        if (MIN_TIME == Integer.MAX_VALUE) MIN_TIME = -1;
        bw.write(MIN_TIME + "");
        output();
    }

    private static boolean spread(Perfume perfume) {

        int count = 0;
        boolean[][] visited = new boolean[N][M];
        Queue<Perfume> needVisit = new LinkedList<>();
        needVisit.add(perfume);
        visited[perfume.y][perfume.x] = true;

        while (!needVisit.isEmpty()) {

            Perfume p = needVisit.poll();

            for (int d = 0; d < 4; d++) {
                int ny = p.y + dy[d];
                int nx = p.x + dx[d];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (visited[ny][nx]) continue;
                    visited[ny][nx] = true;
                    if (map[ny][nx] != 1) {
                        if (map[ny][nx] == 0) {
                            count++;
                            TIME = p.d + 1;
                        }
                        needVisit.add(new Perfume(ny, nx, p.d + 1));
                    }
                }
            }

        }

        return ZERO == count;

    }

}
