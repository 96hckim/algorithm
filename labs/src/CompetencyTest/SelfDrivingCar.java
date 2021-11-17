package CompetencyTest;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Car {

    int y, x, r;

    public Car(int y, int x, int r) {
        this.y = y;
        this.x = x;
        this.r = r;
    }

}

public class SelfDrivingCar {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽기
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 쓰기

    private static int S; // 자동차의 개수
    private static int[][] map; // 지도
    private static Queue<Car> needMove; // 남아있는 자동차
    private static int COLLISION_COUNT; // 충돌 횟수

    private static final int[] dy = {-1, 1, 0, 0}; // y축 이동
    private static final int[] dx = {0, 0, -1, 1}; // x축 이동

    // 입력
    private static void input() throws IOException {
        S = Integer.parseInt(br.readLine());
        map = new int[4001][4001];
        needMove = new LinkedList<>();
        COLLISION_COUNT = 0;

        for (int i = 0; i < S; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) * 2 + 2000;
            int y = Integer.parseInt(st.nextToken()) * -2 + 2000;
            int r = Integer.parseInt(st.nextToken());
            map[y][x]++;
            needMove.add(new Car(y, x, r));
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
            while (!needMove.isEmpty()) bfs(); // 모든 자동차가 사라질 때 까지
            bw.write("#" + t + " " + COLLISION_COUNT + "\n");
            map = null;
        }

        output();

    }

    // 자동차 이동 및 충돌체크
    private static void bfs() {

        int size = needMove.size();
        ArrayList<Car> cars = new ArrayList<>(size);
        for (int s = 0; s < size; s++) {

            Car car = needMove.poll();

            int ny = car.y + dy[car.r];
            int nx = car.x + dx[car.r];

            if (ny >= 0 && ny < map.length && nx >= 0 && nx < map.length) {
                map[car.y][car.x]--;
                map[ny][nx]++;
                cars.add(new Car(ny, nx, car.r));
            }

        }

        for (Car car : cars) {
            if (map[car.y][car.x] == 1) {
                needMove.add(car);
            } else {
                if (map[car.y][car.x] >= 2) {
                    map[car.y][car.x] = 0;
                    COLLISION_COUNT++;
                }
            }
        }

    }
    
}
