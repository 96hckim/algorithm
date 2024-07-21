package Special.diffuser;

import java.io.*;
import java.util.*;

public class Diffuser {

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

    private static int N; // 강의실 세로 크기
    private static int M; // 강의실 가로 크기
    private static int K; // 열어둘 디퓨저 병의 개수

    private static int[][] map; // 강의실
    private static ArrayList<Perfume> perfumes; // 디퓨저 위치
    private static int ZERO; // 빈 공간
    private static int MIN_TIME; // 디퓨저 향이 강의실 전체에 퍼지는데 필요한 최소 시간
    private static int TIME; // 향이 퍼지는데 걸린 시간

    private static final int[] dy = {-1, 1, 0, 0}; // Y축 이동
    private static final int[] dx = {0, 0, -1, 1}; // X축 이동

    // 입력
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        perfumes = new ArrayList<>();
        ZERO = 0;
        MIN_TIME = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); // 0:아무것도 없음, 1:벽, 2:디퓨저 병
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

        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            input();
            permutation(new Perfume[K], 0, 0);
            if (MIN_TIME == Integer.MAX_VALUE) MIN_TIME = -1; // 강의실 전체에 향을 퍼뜨릴 수 없을 경우 -1
            bw.write("#" + t + " " + MIN_TIME + "\n");
        }

        output();

    }

    // 모든 디퓨저 경우의 수
    private static void permutation(Perfume[] select, int x, int from) {
        if (x == K) {
            if (spread(select)) {
                if (MIN_TIME > TIME) MIN_TIME = TIME;
            }
        } else {
            for (int i = from; i < perfumes.size(); i++) {
                select[x] = perfumes.get(i);
                permutation(select, x + 1, i + 1);
            }
        }
    }

    // 선택된 디퓨저의 향이 퍼지는데 걸리는 시간 측정
    private static boolean spread(Perfume[] select) {

        int count = 0;
        boolean[][] visited = new boolean[N][M];
        Queue<Perfume> needVisit = new LinkedList<>();
        Collections.addAll(needVisit, select);
        for (Perfume p : select) visited[p.y][p.x] = true;

        while (!needVisit.isEmpty()) {

            Perfume perfume = needVisit.poll();

            for (int i = 0; i < 4; i++) {

                int ny = perfume.y + dy[i];
                int nx = perfume.x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M) { // 강의실 내
                    if (visited[ny][nx]) continue;
                    visited[ny][nx] = true;
                    if (map[ny][nx] != 1) {
                        if (map[ny][nx] == 0) { // 빈 공간일 경우
                            count++;
                            TIME = perfume.d + 1;
                        }
                        needVisit.add(new Perfume(ny, nx, perfume.d + 1));
                    }
                }

            }

        }

        return count == ZERO; // 강의실 전체에 향 퍼뜨린다면 true

    }

}
