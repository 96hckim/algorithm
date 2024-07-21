package CompetencyTest;

import java.io.*;
import java.util.*;

class Position { // 로봇 청소기 좌표 및 방향

    int y, x, d;

    public Position(int y, int x, int d) {
        this.y = y;
        this.x = x;
        this.d = d;
    }

    @Override
    public String toString() {
        return "Position{" +
                "y=" + y +
                ", x=" + x +
                ", d=" + d +
                '}';
    }

}

public class RobotVacuumCleaner {

    private static int N; // 방 가로, 세로 길이
    private static int[][] room; // 방 배열

    private static HashMap<Integer, ArrayList<Position>> warp; // 워프 장치 좌표

    private static int cleanCount; // 청소한 면적
    private static boolean[][] visited; // 방문했던 구역인지 체크

    private static Position pos; // 현재 좌표 및 방향
    private static int curY; // 현재 Y 좌표
    private static int curX; // 현재 X 좌표

    private static final int[] dy = {-1, 1, 0, 0}; // 상하
    private static final int[] dx = {0, 0, -1, 1}; // 좌우

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 테스트 케이스
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {
            N = Integer.parseInt(br.readLine());
            room = new int[N + 2][N + 2];
            warp = new HashMap<>();

            // 경계선
            boundary();

            // 방 초기화
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    room[i][j] = value;
                    if (value >= 6) {
                        ArrayList<Position> pair = warp.getOrDefault(value, new ArrayList<>());
                        pair.add(new Position(i, j, 0));
                        warp.put(value, pair);
                    }
                }
            }

            // 이동할 수 있는 최댓값 출력
            bw.write("#" + t + " " + getMax() + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    // 경계선 처리
    private static void boundary() {
        for (int i = 0; i < room.length; i++) {
            room[i][0] = room[i][room[0].length - 1] = 5;
        }

        for (int i = 0; i < room[0].length; i++) {
            room[0][i] = room[room.length - 1][i] = 5;
        }
    }

    // 최댓값 가져오기
    private static int getMax() {
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (room[i][j] == 0) { // 장애물이 없는 곳에서 출발
                    for (int k = 0; k < 4; k++) { // 상하좌우 각각 결과 얻기
                        int count = bfs(i, j, k);
                        if (max < count) max = count;
                    }
                }
            }
        }

        return max;
    }

    // 시작 지점과 방향이 주어지고 이동 및 이동 거리 리턴
    private static int bfs(int i, int j, int k) {

        // 방문해야 할 좌표와 방향 저장
        Queue<Position> needVisit = new LinkedList<>();
        needVisit.add(new Position(i, j, k));

        // 카운팅, 방문 체크 초기화
        visited = new boolean[N + 2][N + 2];
        visited[i][j] = true;
        cleanCount = 1;

        while (!needVisit.isEmpty()) {

            pos = needVisit.poll();
            // 현재 좌표
            curY = pos.y;
            curX = pos.x;

            // 다음 이동할 좌표
            pos.y += dy[pos.d];
            pos.x += dx[pos.d];

            // 좌표 혹은 방향 변경
            changePosition();

            // 방문하지 않았던 곳이라면 +1
            visitedCheck();

            // 멈춰야하는지 체크
            if (room[pos.y][pos.x] == -1 || (pos.y == i && pos.x == j && pos.d == k)) { // 낮은 턱 or 출발지일 경우 종료
                if (room[pos.y][pos.x] == -1) cleanCount--; // 낮은 턱은 카운팅하지 않는다
                break;
            } else { // 아닐 경우 다음 행선지 추가
                needVisit.add(pos);
            }

        }

        // 청소한 면적 리턴
        return cleanCount;

    }

    // 장애물 만났을 때 방향 및 좌표 바꿈
    private static void changePosition() {
        switch (room[pos.y][pos.x]) {
            case 1:
                if (pos.d == 3) { // 우 -> 상
                    pos.d = 0;
                } else if (pos.d == 1) { // 하 -> 좌
                    pos.d = 2;
                } else {
                    reverseDir(pos.d);
                }
                break;
            case 2:
                if (pos.d == 1) { // 하 -> 우
                    pos.d = 3;
                } else if (pos.d == 2) { // 좌 -> 상
                    pos.d = 0;
                } else {
                    reverseDir(pos.d);
                }
                break;
            case 3:
                if (pos.d == 0) { // 상 -> 우
                    pos.d = 3;
                } else if (pos.d == 2) { // 좌 -> 하
                    pos.d = 1;
                } else {
                    reverseDir(pos.d);
                }
                break;
            case 4:
                if (pos.d == 3) { // 우 -> 하
                    pos.d = 1;
                } else if (pos.d == 0) { // 상 -> 좌
                    pos.d = 2;
                } else {
                    reverseDir(pos.d);
                }
                break;
            case 5: // 모든 방면 반대로 튕기다
                reverseDir(pos.d);
                break;
            case 6: // 6 ~ 10 워프 장치
            case 7:
            case 8:
            case 9:
            case 10:
                visitedCheck();

                // 쌍이 되는 워프 장치 좌표로 이동
                ArrayList<Position> pairs = warp.get(room[pos.y][pos.x]);
                if (pos.y == pairs.get(0).y && pos.x == pairs.get(0).x) {
                    pos.y = pairs.get(1).y;
                    pos.x = pairs.get(1).x;
                } else {
                    pos.y = pairs.get(0).y;
                    pos.x = pairs.get(0).x;
                }
                break;
        }
    }

    // 진행 방향 역전
    private static void reverseDir(int dir) {
        pos.y = curY;
        pos.x = curX;

        switch (dir) {
            case 0:
                pos.d = 1;
                break;
            case 1:
                pos.d = 0;
                break;
            case 2:
                pos.d = 3;
                break;
            case 3:
                pos.d = 2;
                break;
        }

        // 현재 위치가 장애물일 수 있으므로 한번더 포지션 변경해야하는지 체크
        changePosition();
    }

    // 방문 체크 (방문하지 않았더라면 +1)
    private static void visitedCheck() {
        if (!visited[pos.y][pos.x]) {
            visited[pos.y][pos.x] = true;
            cleanCount++;
        }
    }

}
