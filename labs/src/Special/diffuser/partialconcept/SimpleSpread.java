package Special.diffuser.partialconcept;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SimpleSpread {

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
        bw.write(spread() + "");
        output();
    }

    private static int spread() {

        int result = 0;
        int count = 0;
        boolean[][] visited = new boolean[N][M];
        Queue<Perfume> needVisit = new LinkedList<>(perfumes);
        for (Perfume p : perfumes) visited[p.y][p.x] = true;

        while (!needVisit.isEmpty()) {

            Perfume perfume = needVisit.poll();

            for (int d = 0; d < 4; d++) {
                int ny = perfume.y + dy[d];
                int nx = perfume.x + dx[d];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (visited[ny][nx]) continue;
                    visited[ny][nx] = true;
                    if (map[ny][nx] != 1) {
                        if (map[ny][nx] == 0) {
                            count++;
                            result = perfume.d + 1;
                        }
                        needVisit.add(new Perfume(ny, nx, perfume.d + 1));
                    }
                }
            }

        }

        if (ZERO == count) return result;
        else return -1;
    }
    
}
