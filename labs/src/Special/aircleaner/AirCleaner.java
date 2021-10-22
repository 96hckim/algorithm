package Special.aircleaner;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AirCleaner {

    private static int r;               // 강의실 크기 (세로)
    private static int c;               // 강의실 크기 (가로)
    private static int s;               // 시간
    private static int k;               // 퍼지는 거리
    private static int divideValue;     // 기준 위치 나쁨 정도와 나눌 값
    private static int sum;             // 강의실 전체 공기의 나쁨 정도의 합
    private static int[][] roomArray;   // 강의실 좌표 배열
    private static ArrayList<Integer> airCleaners; // 공기청정기 좌표
    private static int[][] spreadArray; // 확산값 저장

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 테스트 케이스
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {

            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            divideValue = 2 * k * k + 2 * k + 1;
            sum = 0;
            roomArray = new int[r + 2][c + 2];
            airCleaners = new ArrayList<>(2);

            // 강의실 초기화
            for (int i = 1; i <= r; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= c; j++) {
                    int value = Integer.parseInt(st.nextToken());

                    if (value == -1) airCleaners.add(i); // -1 : 공기청정기

                    roomArray[i][j] = value;
                }
            }


            // s초 확산 및 밀기
            for (int i = 0; i < s; i++) {

                // 확산배열 초기화
                spreadArray = new int[r + 2][c + 2];

                // 확산할 값 가져오기
                for (int j = 1; j <= r; j++) {
                    for (int l = 1; l <= c; l++) {
                        getNumberToSpread(j, l);
                    }
                }

                // 확산값 더해 강의실 공기 상태 갱신
                updateRoom();

                // 밀기
                push();

            }

            // 최종 나쁨 정도 합계
            sum();

            // 출력
            bw.write("#" + (t + 1) + " " + sum + "\n");

        }

        br.close();
        bw.flush();
        bw.close();

    }

    // 확산할 값 가져오기
    private static void getNumberToSpread(int x, int y) {
        int q = roomArray[x][y] / divideValue;

        if (q > 0) {

            for (int i = x - k; i <= x + k; i++) {

                if (i < 1 || i > r) continue;

                for (int j = y - k; j <= y + k; j++) {

                    if (j < 1 || j > c) continue;
                    if (i == x && j == y) continue;
                    if (roomArray[i][j] == -1) continue;

                    int distance = Math.abs(x - i) + Math.abs(y - j);

                    if (distance <= k) {
                        spreadArray[i][j] += q;
                        spreadArray[x][y] -= q;
                    }

                }

            }

        }
    }

    // 강의실 공기 상태 업데이트
    private static void updateRoom() {
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                roomArray[i][j] += spreadArray[i][j];
            }
        }
    }

    // 공기 밀기
    private static void push() {

        int u = airCleaners.get(0); // 상단 공기청정기
        int d = airCleaners.get(1); // 하단 공기청정기

        // 시계 방향

        int temp = roomArray[1][1];

        for (int i = 1; i < u; i++) roomArray[i][1] = roomArray[i + 1][1];

        for (int j = 1; j < c; j++) roomArray[u][j] = roomArray[u][j + 1];

        for (int i = u; i > 1; i--) roomArray[i][c] = roomArray[i - 1][c];

        for (int j = c; j > 2; j--) roomArray[1][j] = roomArray[1][j - 1];

        roomArray[1][2] = temp;

        // 반시계 방향

        temp = roomArray[d][1];

        for (int i = 1; i < c; i++) roomArray[d][i] = roomArray[d][i + 1];

        for (int j = d; j < r; j++) roomArray[j][c] = roomArray[j + 1][c];

        for (int i = c; i > 1; i--) roomArray[r][i] = roomArray[r][i - 1];

        for (int j = r; j > d + 1; j--) roomArray[j][1] = roomArray[j - 1][1];

        roomArray[d + 1][1] = temp;

        // 공기청정기 재배치 및 바로 앞 공기정화
        roomArray[u][c] = roomArray[d][c] = -1;
        roomArray[u][c - 1] = roomArray[d][c - 1] = 0;

    }

    // 강의실 전체 공기 나쁨 정도의 합
    private static void sum() {
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                sum += roomArray[i][j];
            }
        }

        sum += 2; // 공기청정기 (-1) 상쇄
    }

}
