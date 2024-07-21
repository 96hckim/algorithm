package CompetencyTest;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Balloon {

    int y;
    int x;
    int range;

    public Balloon(int y, int x, int range) {
        this.y = y;
        this.x = x;
        this.range = range;
    }

    @Override
    public String toString() {
        return "Balloon{" +
                "y=" + y +
                ", x=" + x +
                ", range=" + range +
                '}';
    }

}

public class RemoveBalloon {

    private static int N; // 빌리지의 세로 크기
    private static int M; // 빌리지의 가로 크기
    private static int K; // 바늘의 개수
    private static Balloon[][] village; // 빌리지 배열

    private static LinkedList<Balloon> needRemove; // 범위가 큰 풍선 순으로 저장
    private static LinkedList<Balloon> maxRemoveList; // 이번 회차에서 가장 많이 지울 수 있는 풍선 리스트

    private static final int[] dy = {-1, 1, 0, 0}; // 상하
    private static final int[] dx = {0, 0, -1, 1}; // 좌우

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 테스트 케이스
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {

            // 초기화
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            village = new Balloon[N][M];
            needRemove = new LinkedList<>();

            // 마을 풍선 초기화
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int range = Integer.parseInt(st.nextToken());
                    if (range > 0) { // 풍선이 있을 경우
                        village[i][j] = new Balloon(i, j, range);
                        needRemove.add(village[i][j]);
                    }
                }
            }

            // 풍선이 안 남을떄 까지 지운다
            while (!needRemove.isEmpty()) removeBalloon();

            if (K >= 0) K = 0; // 바늘이 남아있을 경우 추가 바늘 필요 X
            else K = Math.abs(K); // 음수일 경우 절대값만큼 바늘이 필요

            // 필요한 바늘 수 출력
            bw.write("#" + t + " " + K + "\n");

        }

        br.close();
        bw.flush();
        bw.close();

    }

    // 당 회차 풍선 지우기
    static void removeBalloon() {
        maxRemoveList = new LinkedList<>();
        for (Balloon b : needRemove) getMaxRemoveList(b);
        for (Balloon b : maxRemoveList) village[b.y][b.x] = null;
        needRemove.removeAll(maxRemoveList);
        K--;
    }

    // 지울 수 있는 풍선 리스트 선별
    private static void getMaxRemoveList(Balloon balloon) {

        LinkedList<Balloon> removeList = new LinkedList<>();
        Queue<Balloon> needVisit = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        removeList.add(balloon);
        needVisit.add(balloon);
        visited[balloon.y][balloon.x] = true;

        while (!needVisit.isEmpty()) {

            Balloon b = needVisit.poll();

            for (int i = 0; i < 4; i++) {
                for (int j = 1; j <= b.range; j++) {
                    int ny = b.y + dy[i] * j;
                    int nx = b.x + dx[i] * j;

                    if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                        if (!visited[ny][nx]) {
                            visited[ny][nx] = true;

                            if (village[ny][nx] != null) {
                                removeList.add(village[ny][nx]);
                                needVisit.add(village[ny][nx]);
                            }
                        }
                    }
                }
            }

        }

        if (maxRemoveList.size() < removeList.size()) maxRemoveList = removeList;

    }

}
